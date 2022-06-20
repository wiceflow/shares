package com.wiceflow.shares.config;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author BF
 * @date 2022/6/20
 */
@Component
public class RestTemplateConfig {

    private static SimpleClientHttpRequestFactory factory;

    @PostConstruct
    public void init() {
        factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(1000);
    }

    public SimpleClientHttpRequestFactory getFactory() {
        return factory;
    }
}
