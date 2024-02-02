package com.suchtool.nacosopenapi.api.constant;

import lombok.Getter;
import org.springframework.http.HttpMethod;

@Getter
public enum NacosOpenApiV1UrlEnum {
    LOGIN(HttpMethod.POST, "nacos/v1/auth/users/login", false),
    QUERY_ALL_NAMESPACES(HttpMethod.GET, "nacos/v1/console/namespaces", true),
    QUERY_SERVICE(HttpMethod.GET, "nacos/v1/ns/catalog/services", false),
    QUERY_INSTANCE(HttpMethod.GET, "nacos/v1/ns/catalog/service", false),
    ;

    private final HttpMethod httpMethod;

    private final String url;

    /**
     * 是否要包装返回值
     */
    private final Boolean wrap;

    NacosOpenApiV1UrlEnum(HttpMethod httpMethod, String url, Boolean wrap) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.wrap = wrap;
    }
}
