package com.suchtool.nacosopenapi.api.v1.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class V1InstancePageBO extends V1CommonPageBO {
    private String serviceName;

    private String clusterName = "DEFAULT";

    private String groupName = "DEFAULT_GROUP";

    private String namespaceId;
}
