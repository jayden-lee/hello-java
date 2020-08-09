package com.jayden.client.web.dto;

import lombok.Getter;

@Getter
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;
}