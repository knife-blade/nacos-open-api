package com.suchtool.nacosopenapi.util.resttemplate;

import com.suchtool.nacosopenapi.util.resttemplate.config.CustomClientHttpRequestInterceptor;
import com.suchtool.nacosopenapi.util.resttemplate.config.CustomResponseErrorHandler;
import com.suchtool.nacosopenapi.property.RestTemplateProperty;
import com.suchtool.nicetool.util.spring.ApplicationContextHolder;
import okhttp3.OkHttpClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class NacosRestTemplateUtil {
    private static final RestTemplate restTemplate = createRestTemplate();

    private static RestTemplate createRestTemplate() {
        RestTemplateProperty restTemplateProperty = ApplicationContextHolder
                .getContext().getBean(RestTemplateProperty.class);

        return new RestTemplateBuilder()
                .requestFactory(NacosRestTemplateUtil::getClientHttpRequestFactory)
                .setConnectTimeout(restTemplateProperty.getConnectTimeout())
                .setReadTimeout(restTemplateProperty.getReadTimeout())
                // 响应异常处理。应用场景：响应状态200是正常，可以做统一的非200响应码的拦截
                .errorHandler(new CustomResponseErrorHandler())
                // 设置请求拦截。应用场景：添加一些全局的请求头等。可创建多个，执行顺序和list中对象的顺序一致。
                .interceptors(new CustomClientHttpRequestInterceptor())
                // 设置信息转换对象。应用场景：设置一些编码格式、数据类型、json/xml等的类型转换器等。
                // .messageConverters(List<HttpMessageConverter<?>> messageConverters)
                // 配置一个扩展uri模板的策略。应用场景：添加一些统一的请求前缀等。
                // .uriTemplateHandler(UriTemplateHandler handler)
                .build();
    }

    /**
     * 使用OkHttpClient作为底层客户端（要引入okhttp依赖：com.squareup.okhttp3:okhttp:xxx）
     */
    private static ClientHttpRequestFactory getClientHttpRequestFactory(){
        // 这里设置超时时间是无效的，以外边的restTemplateBuilder.setXxxTimeout为准
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                // .connectTimeout(5, TimeUnit.SECONDS)
                // .readTimeout(5, TimeUnit.SECONDS)
                // .writeTimeout(5, TimeUnit.SECONDS)
                .build();
        return new OkHttp3ClientHttpRequestFactory(okHttpClient);
    }

    public static RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
