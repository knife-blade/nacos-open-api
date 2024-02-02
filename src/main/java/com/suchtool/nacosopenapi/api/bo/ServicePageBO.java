package com.suchtool.nacosopenapi.api.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServicePageBO extends CommonPageBO {
    private Boolean hasIpCount = true;

    private Boolean withInstances = false;

    private String serviceNameParam = "";

    private String groupNameParam = "";

    private String namespaceId = "";
}
