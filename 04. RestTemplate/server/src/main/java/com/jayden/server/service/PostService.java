package com.jayden.server.service;

import com.jayden.server.domain.Post;
import com.jayden.server.domain.PostRepository;
import com.jayden.server.web.dto.PostListResponseDto;
import com.jayden.server.web.dto.PostResponseDto;
import com.jayden.server.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostSaveRequestDto requestDto) {
        Post post = postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        post.update(requestDto.getTitle(), requestDto.getContent());

        return post.getId();
    }

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllDesc().stream()
            .map(PostListResponseDto::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public Long delete(Long id) {
        Post post = postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postRepository.delete(post);

        return id;
    }
}