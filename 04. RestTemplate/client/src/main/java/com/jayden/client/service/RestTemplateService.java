package com.jayden.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public ResponseEntity get(String url, HttpHeaders httpHeaders) {
        return send(url, HttpMethod.GET, httpHeaders, null, Object.class);
    }

    public ResponseEntity post(String url, HttpHeaders httpHeaders, Object body) {
        return send(url, HttpMethod.POST, httpHeaders, body, Object.class);
    }

    public ResponseEntity put(String url, HttpHeaders httpHeaders, Object body) {
        return send(url, HttpMethod.PUT, httpHeaders, body, Object.class);
    }

    public ResponseEntity delete(String url, HttpHeaders httpHeaders) {
        return send(url, HttpMethod.DELETE, httpHeaders, null, Object.class);
    }

    private ResponseEntity send(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Object body, Class clazz) {
        return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, httpHeaders), clazz);
    }
}
