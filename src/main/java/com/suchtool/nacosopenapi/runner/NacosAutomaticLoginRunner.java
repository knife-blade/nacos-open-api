package com.suchtool.nacosopenapi.runner;

import com.suchtool.nacosopenapi.api.NacosOpenApiTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * 自动登录
 */
@Slf4j
public class NacosAutomaticLoginRunner implements ApplicationRunner {
    @Autowired
    private NacosOpenApiTokenUtil nacosOpenApiTokenUtil;

    @Override
    public void run(ApplicationArguments args)  {
        try {
            nacosOpenApiTokenUtil.createToken();
        } catch (Throwable t) {
            log.error("自动登录Nacos报错", t);
        }
    }
}