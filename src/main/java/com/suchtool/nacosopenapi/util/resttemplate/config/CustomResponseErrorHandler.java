package com.suchtool.nacosopenapi.util.resttemplate.config;

import com.suchtool.nacosopenapi.api.NacosOpenApiTokenUtil;
import com.suchtool.nicetool.util.spring.ApplicationContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class CustomResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = response.getStatusCode();
        return HttpStatus.FORBIDDEN.equals(statusCode);
    }

    @Override
    public void handleError(ClientHttpResponse response) {
        NacosOpenApiTokenUtil nacosOpenApiTokenUtil = ApplicationContextHolder
                .getContext().getBean(NacosOpenApiTokenUtil.class);

        nacosOpenApiTokenUtil.createToken();
    }
}
