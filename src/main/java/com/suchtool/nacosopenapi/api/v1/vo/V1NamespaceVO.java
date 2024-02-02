package com.suchtool.nacosopenapi.api.v1.vo;

import lombok.Data;

@Data
public class V1NamespaceVO {
    private String namespace;

    private String namespaceShowName;

    private String namespaceDesc;

    private Integer quota;

    private Integer configCount;

    private Integer type;
}
