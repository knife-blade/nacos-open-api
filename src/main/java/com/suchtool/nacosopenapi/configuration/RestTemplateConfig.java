package com.suchtool.nacosopenapi.configuration;

import com.suchtool.nacosopenapi.property.RestTemplateProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class RestTemplateConfig {

    @Bean("suchtool.nacosopenapi.restTemplateProperty")
    @ConfigurationProperties(prefix = "suchtool.nacosopenapi.resttemplate")
    public RestTemplateProperty restTemplateProperty() {
        return new RestTemplateProperty();
    }

}