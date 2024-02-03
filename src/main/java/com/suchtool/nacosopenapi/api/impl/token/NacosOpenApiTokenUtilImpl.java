package com.suchtool.nacosopenapi.api.impl.token;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.suchtool.nacosopenapi.api.NacosOpenApiTokenUtil;
import com.suchtool.nacosopenapi.api.NacosOpenApiUtil;
import com.suchtool.nacosopenapi.api.bo.NacosLoginBO;
import com.suchtool.nacosopenapi.api.vo.NacosLoginVO;
import org.springframework.beans.factory.annotation.Autowired;

public class NacosOpenApiTokenUtilImpl implements NacosOpenApiTokenUtil {
    @Autowired
    private NacosOpenApiUtil nacosOpenApiUtil;

    @Autowired
    private NacosDiscoveryProperties nacosServerProperty;

    private String accessToken;

    @Override
    public void createToken() {
        NacosLoginBO nacosLoginBO = new NacosLoginBO();
        nacosLoginBO.setUsername(nacosServerProperty.getUsername());
        nacosLoginBO.setPassword(nacosServerProperty.getPassword());

        NacosLoginVO loginVO = nacosOpenApiUtil.login(nacosLoginBO);

        accessToken = loginVO.getAccessToken();
    }

    @Override
    public String readToken() {
        return accessToken;
    }
}
