package com.suchtool.nacosopenapi.api.vo;

import lombok.Data;

@Data
public class NamespaceVO {
    private String namespace;

    private String namespaceShowName;

    private String namespaceDesc;

    private Integer quota;

    private Integer configCount;

    private Integer type;
}
