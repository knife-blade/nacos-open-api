package com.suchtool.nacosopenapi.api.vo;

import lombok.Data;

@Data
public class NacosLoginVO {
    private String accessToken;

    private Integer tokenTtl;

    private Boolean globalAdmin;

    private String username;

}