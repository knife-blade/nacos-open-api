package com.suchtool.nacosopenapi.api;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class NacosOpenApiUtil {
    @Autowired
    private NacosDiscoveryProperties nacosServerProperty;

    @Autowired
    private RestTemplate restTemplate;

    private String AccessToken;

    public String login() {

        return null;
    }
}
