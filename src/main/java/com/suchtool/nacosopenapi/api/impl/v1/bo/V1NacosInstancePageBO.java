package com.suchtool.nacosopenapi.api.impl.v1.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class V1NacosInstancePageBO extends V1NacosCommonPageBO {
    private String serviceName;

    private String clusterName = "DEFAULT";

    private String groupName = "DEFAULT_GROUP";

    private String namespaceId;
}
