package com.suchtool.nacosopenapi.api.vo;

import lombok.Data;

import java.util.List;

@Data
public class ServiceQueryVO {
    private Integer count;

    private List<ServiceList> serviceList;

    @Data
    public static class ServiceList {
        private String name;

        private String groupName;

        private Integer clusterCount;

        private Integer ipCount;

        private Integer healthyInstanceCount;

        private String triggerFlag;

    }

}