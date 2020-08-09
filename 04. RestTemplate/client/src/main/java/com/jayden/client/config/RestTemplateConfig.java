package com.jayden.client.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        // create http client pool
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();

        HttpClient httpClient = HttpClientBuilder.create()
            .setMaxConnTotal(150)
            .setMaxConnPerRoute(30)
            .build();

        clientHttpRequestFactory.setHttpClient(httpClient);

        // for ResponseEntity body copy
        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(clientHttpRequestFactory);

        return restTemplateBuilder
            .requestFactory(() -> bufferingClientHttpRequestFactory)
            .setConnectTimeout(Duration.ofMillis(30000))
            .setReadTimeout(Duration.ofMillis(30000))
            .additionalMessageConverters(new StringHttpMessageConverter(Charset.forName("UTF-8")))
            .additionalInterceptors(new RestTemplateLoggingInterceptor())
            .build();
    }
}
