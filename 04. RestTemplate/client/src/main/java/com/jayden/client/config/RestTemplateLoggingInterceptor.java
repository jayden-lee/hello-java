package com.jayden.client.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest req, byte[] reqBody, ClientHttpRequestExecution ex)
        throws IOException {

        log.info("[REQUEST] Uri: {}, Method: {}, Request Body: {}", req.getURI(), req.getMethod(),
            new String(reqBody, StandardCharsets.UTF_8));

        ClientHttpResponse response = ex.execute(req, reqBody);

        log.info("[RESPONSE] Uri: {}. Status Code: {}, Response Body: {}", req.getURI(),
            response.getStatusCode(), StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));

        return response;
    }
}