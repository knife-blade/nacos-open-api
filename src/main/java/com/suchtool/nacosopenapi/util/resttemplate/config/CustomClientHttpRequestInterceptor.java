package com.suchtool.nacosopenapi.util.resttemplate.config;

import com.suchtool.nacosopenapi.property.RestTemplateProperty;
import com.suchtool.nicetool.util.spring.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        RestTemplateProperty restTemplateProperty = ApplicationContextHolder
                .getContext().getBean(RestTemplateProperty.class);
        if (restTemplateProperty.getDebug()) {
            log.info("Nacos请求：HTTP Method: {}, URI: {}, Headers: {}, Body: {}",
                    request.getMethod(), request.getURI(), request.getHeaders(),
                    body == null ? "null" : new String(body, StandardCharsets.UTF_8));
        }

        ClientHttpResponse response = execution.execute(request, body);

        // 包装response，可以多次getBody。若不包装，执行getBody后body流就空了，再次读就读不到了
        CustomBufferingClientHttpResponseWrapper responseWrapper =
                new CustomBufferingClientHttpResponseWrapper(response);

        if (restTemplateProperty.getDebug()) {
            String responseBody = StreamUtils.copyToString(responseWrapper.getBody(), StandardCharsets.UTF_8);
            log.info("Nacos响应体: {}", responseBody);
        }

        return responseWrapper;
    }
}
