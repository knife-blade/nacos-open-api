package com.suchtool.nacosopenapi.runner;

import com.suchtool.nacosopenapi.api.NacosOpenApiTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * 自动登录
 */
public class NacosAutomaticLoginRunner implements ApplicationRunner {
    @Autowired
    private NacosOpenApiTokenUtil nacosOpenApiTokenUtil;

    @Override
    public void run(ApplicationArguments args)  {
        nacosOpenApiTokenUtil.createToken();
    }
}