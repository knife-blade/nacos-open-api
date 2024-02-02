package com.suchtool.nacosopenapi.api;

import com.suchtool.nacosopenapi.property.NacosServerProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class NacosOpenApiUtil {
    @Autowired
    private NacosServerProperty nacosServerProperty;

    @Autowired
    private RestTemplate restTemplate;

    private String AccessToken;

    public String login() {
        return null;
    }
}
