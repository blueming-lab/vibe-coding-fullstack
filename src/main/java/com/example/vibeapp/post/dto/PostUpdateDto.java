package com.example.vibeapp.post.dto;

import com.example.vibeapp.post.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PostUpdateDto(
        @NotEmpty(message = "제목은 필수입니다.") @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") String title,

        String content) {
    public void updateEntity(Post post) {
        post.setTitle(this.title);
        post.setContent(this.content);
    }
}
