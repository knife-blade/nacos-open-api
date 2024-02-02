package com.suchtool.nacosopenapi.configuration;

import com.suchtool.nacosopenapi.api.NacosOpenApiUtil;
import com.suchtool.nacosopenapi.property.NacosServerProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class NacosOpenApiConfiguration  {
    @Bean("suchtool.nacosopenapi.nacosServerProperty")
    @ConfigurationProperties(prefix = "suchtool.nacosopenapi.nacos")
    public NacosServerProperty nacosServerProperty() {
        return new NacosServerProperty();
    }

    @Bean("suchtool.nacosopenapi.nacosOpenApiUtil")
    public NacosOpenApiUtil nacosOpenApiUtil() {
        return new NacosOpenApiUtil();
    }
}
