package com.unfbx.chatgptsteamoutput.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiurui
 * @description
 * @date 2023/3/27
 */
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate registerTemplate() {
        RestTemplate restTemplate = new RestTemplate(getFactory());
        //这个地方需要配置消息转换器，不然收到消息后转换会出现异常
        restTemplate.setMessageConverters(getConverts());
        return restTemplate;
    }

    private SimpleClientHttpRequestFactory getFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(60000);
        factory.setReadTimeout(60000);
        return factory;
    }

    private List<HttpMessageConverter<?>> getConverts() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        // String转换器
        StringHttpMessageConverter stringConvert = new StringHttpMessageConverter();
        List<MediaType> stringMediaTypes = new ArrayList<MediaType>() {{
            //添加响应数据格式，不匹配会报401
            add(MediaType.TEXT_PLAIN);
            add(MediaType.TEXT_HTML);
            add(MediaType.APPLICATION_JSON);
        }};
        stringConvert.setSupportedMediaTypes(stringMediaTypes);
        messageConverters.add(stringConvert);
        return messageConverters;
    }
}
