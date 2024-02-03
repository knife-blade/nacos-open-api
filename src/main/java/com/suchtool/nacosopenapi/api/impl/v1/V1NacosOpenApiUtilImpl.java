package com.suchtool.nacosopenapi.api.impl.v1;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.suchtool.nacosopenapi.api.NacosOpenApiTokenUtil;
import com.suchtool.nacosopenapi.api.NacosOpenApiUtil;
import com.suchtool.nacosopenapi.api.bo.NacosInstancePageBO;
import com.suchtool.nacosopenapi.api.bo.NacosLoginBO;
import com.suchtool.nacosopenapi.api.bo.NacosServicePageBO;
import com.suchtool.nacosopenapi.api.impl.v1.bo.V1NacosAccessBO;
import com.suchtool.nacosopenapi.api.impl.v1.constant.V1NacosOpenApiUrlEnum;
import com.suchtool.nacosopenapi.api.impl.v1.vo.*;
import com.suchtool.nacosopenapi.api.vo.NacosInstanceVO;
import com.suchtool.nacosopenapi.api.vo.NacosLoginVO;
import com.suchtool.nacosopenapi.api.vo.NacosNamespaceVO;
import com.suchtool.nacosopenapi.api.vo.NacosServiceVO;
import com.suchtool.niceutil.util.base.BeanUtil;
import com.suchtool.niceutil.util.base.JsonUtil;
import com.suchtool.niceutil.util.web.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1NacosOpenApiUtilImpl implements NacosOpenApiUtil {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NacosDiscoveryProperties nacosServerProperty;

    @Autowired
    private NacosOpenApiTokenUtil nacosOpenApiTokenUtil;

    @Override
    public NacosLoginVO login(NacosLoginBO nacosLoginBO) {
        V1NacosLoginVO v1NacosLoginVO = doRequest(V1NacosOpenApiUrlEnum.LOGIN,
                nacosLoginBO, V1NacosLoginVO.class, false);

        return BeanUtil.copy(v1NacosLoginVO, NacosLoginVO.class);
    }

    @Override
    public List<NacosNamespaceVO> queryAllNamespace() {
        V1NacosCommonVO<?> v1NacosCommonVO = doRequest(V1NacosOpenApiUrlEnum.QUERY_ALL_NAMESPACES,
                null, V1NacosCommonVO.class, true);
        Object data = v1NacosCommonVO.getData();
        String jsonString = JsonUtil.toJsonString(data);

        return JsonUtil.toObjectList(jsonString, new TypeReference<List<NacosNamespaceVO>>() {});
    }

    @Override
    public List<NacosServiceVO> queryService(NacosServicePageBO nacosServicePageBO) {
        V1NacosServiceVO v1NacosServiceVO = doRequest(V1NacosOpenApiUrlEnum.QUERY_SERVICE,
                nacosServicePageBO, V1NacosServiceVO.class, true);
        List<V1NacosServiceVO.ServiceList> serviceList = v1NacosServiceVO.getServiceList();

        return BeanUtil.copy(serviceList, NacosServiceVO.class);
    }

    @Override
    public List<NacosInstanceVO> queryInstance(NacosInstancePageBO nacosInstancePageBO) {
        V1NacosInstanceVO v1NacosInstanceVO = doRequest(V1NacosOpenApiUrlEnum.QUERY_INSTANCE,
                nacosInstancePageBO, V1NacosInstanceVO.class, true);
        List<V1NacosInstanceVO.InstanceVO> instanceVOList = v1NacosInstanceVO.getInstanceVOList();

        return BeanUtil.copy(instanceVOList, NacosInstanceVO.class);
    }

    private <T> T doRequest(V1NacosOpenApiUrlEnum v1NacosOpenApiUrlEnum,
                            Object param,
                            Class<T> cls,
                            Boolean requireToken) {
        List<Object> paramList = new ArrayList<>();
        if (param != null) {
            paramList.add(param);
        }
        if (requireToken) {
            V1NacosAccessBO v1NacosAccessBO = new V1NacosAccessBO();
            v1NacosAccessBO.setAccessToken(nacosOpenApiTokenUtil.readToken());
            paramList.add(v1NacosAccessBO);
        }

        String url = HttpUtil.joinUrl(Arrays.asList(nacosServerProperty.getServerAddr(),
                v1NacosOpenApiUrlEnum.getUrl()));
        url = HttpUtil.buildUrlWithParams(url, paramList);

        if (HttpMethod.GET.equals(v1NacosOpenApiUrlEnum.getHttpMethod())) {
            return restTemplate.getForObject(url, cls);
        } else if (HttpMethod.POST.equals(v1NacosOpenApiUrlEnum.getHttpMethod())) {
            return restTemplate.postForObject(url, null, cls);
        } else {
            return null;
        }
    }
}
