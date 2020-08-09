package com.jayden.client.web.dto;

import lombok.Getter;

@Getter
public class PostUpdateRequestDto {
    private String title;
    private String content;
    private String author;
}
