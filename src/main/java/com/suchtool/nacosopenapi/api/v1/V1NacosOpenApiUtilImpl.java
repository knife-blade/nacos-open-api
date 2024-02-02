package com.suchtool.nacosopenapi.api.v1;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class V1NacosOpenApiUtilImpl {
    @Autowired
    private NacosDiscoveryProperties nacosServerProperty;

    @Autowired
    private RestTemplate restTemplate;

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String login() {

        return null;
    }
}
