package com.suchtool.nacosopenapi.configuration;

import com.suchtool.nacosopenapi.api.NacosOpenApiTokenUtil;
import com.suchtool.nacosopenapi.api.NacosOpenApiUtil;
import com.suchtool.nacosopenapi.api.impl.token.NacosOpenApiTokenUtilImpl;
import com.suchtool.nacosopenapi.api.impl.v1.V1NacosOpenApiUtilImpl;
import com.suchtool.nacosopenapi.property.NacosOpenApiProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class NacosOpenApiConfiguration  {
    @Bean("suchtool.nacosopenapi.nacosOpenApiUtil")
    @ConditionalOnProperty(value = "suchtool.nacosopenapi.nacos.version", havingValue = "v1", matchIfMissing = true)
    public NacosOpenApiUtil nacosOpenApiUtil() {
        return new V1NacosOpenApiUtilImpl();
    }

    @Bean("suchtool.nacosopenapi.nacosOpenApiTokenUtil")
    public NacosOpenApiTokenUtil nacosOpenApiTokenUtil() {
        return new NacosOpenApiTokenUtilImpl();
    }

    @Bean("suchtool.nacosopenapi.nacosOpenApiProperty")
    @ConditionalOnProperty(value = "suchtool.nacosopenapi.nacos.version", havingValue = "v1", matchIfMissing = true)
    @ConfigurationProperties("suchtool.nacosopenapi.nacos")
    public NacosOpenApiProperty nacosOpenApiProperty() {
        return new NacosOpenApiProperty();
    }
}
