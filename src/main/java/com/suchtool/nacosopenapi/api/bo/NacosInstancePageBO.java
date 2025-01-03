package com.suchtool.nacosopenapi.api.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NacosInstancePageBO extends NacosCommonPageBO {
    private String serviceName;

    private String clusterName = "DEFAULT";

    private String groupName = "DEFAULT_GROUP";

    private String namespaceId;
}
