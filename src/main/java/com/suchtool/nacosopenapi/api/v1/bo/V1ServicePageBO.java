package com.suchtool.nacosopenapi.api.v1.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class V1ServicePageBO extends V1CommonPageBO {
    private Boolean hasIpCount = true;

    private Boolean withInstances = false;

    private String serviceNameParam = "";

    private String groupNameParam = "";

    private String namespaceId = "";
}
