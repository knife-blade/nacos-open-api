package com.suchtool.nacosopenapi.configuration;

import com.suchtool.nacosopenapi.api.v1.V1NacosOpenApiUtilImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class NacosOpenApiConfiguration  {
    @Bean("suchtool.nacosopenapi.nacosOpenApiUtil")
    public V1NacosOpenApiUtilImpl nacosOpenApiUtil() {
        return new V1NacosOpenApiUtilImpl();
    }
}
