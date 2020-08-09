package com.jayden.client.web;

import com.jayden.client.service.RestTemplateService;
import com.jayden.client.web.dto.PostSaveRequestDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/posts")
public class PostApiController {

    private final RestTemplateService restTemplateService;

    public PostApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    public static final String HTTP_URL = "http://localhost:8081";

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PostSaveRequestDto requestDto) {
        URI uri = UriComponentsBuilder.fromHttpUrl(HTTP_URL)
            .path("/api/v1/posts")
            .build()
            .encode()
            .toUri();

        ResponseEntity responseEntity = restTemplateService.post(uri.toString(), HttpHeaders.EMPTY, requestDto);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok().build();
        }

        throw new RuntimeException("Failed to create post");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PostSaveRequestDto requestDto) {
        URI uri = UriComponentsBuilder.fromHttpUrl(HTTP_URL)
            .path("/api/v1/posts/{id}")
            .build()
            .expand(id)
            .encode()
            .toUri();

        ResponseEntity responseEntity = restTemplateService.put(uri.toString(), HttpHeaders.EMPTY, requestDto);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Object body = responseEntity.getBody();
            return ResponseEntity.ok(body);
        }

        throw new RuntimeException("Failed to update post");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        URI uri = UriComponentsBuilder.fromHttpUrl(HTTP_URL)
            .path("/api/v1/posts/{id}")
            .build()
            .expand(id)
            .encode()
            .toUri();

        ResponseEntity responseEntity = restTemplateService.get(uri.toString(), HttpHeaders.EMPTY);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Object body = responseEntity.getBody();
            return ResponseEntity.ok(body);
        }

        throw new RuntimeException("Failed to get post");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        URI uri = UriComponentsBuilder.fromHttpUrl(HTTP_URL)
            .path("/api/v1/posts/{id}")
            .build()
            .expand(id)
            .encode()
            .toUri();

        ResponseEntity responseEntity = restTemplateService.delete(uri.toString(), HttpHeaders.EMPTY);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Object body = responseEntity.getBody();
            return ResponseEntity.ok(body);
        }

        throw new RuntimeException("Failed to delete post");
    }
}