package com.suchtool.nacosopenapi.api.impl.v1.vo;

import lombok.Data;

@Data
public class V1NacosLoginVO {
    private String accessToken;

    private Integer tokenTtl;

    private Boolean globalAdmin;

    private String username;

}