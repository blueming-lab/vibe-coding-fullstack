package com.example.vibeapp;

import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private static final List<Post> posts = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            posts.add(new Post(
                    (long) i,
                    "샘플 게시글 제목 " + i,
                    "이것은 샘플 게시글 " + i + "의 내용입니다.",
                    LocalDateTime.now().minusDays(10 - i),
                    LocalDateTime.now().minusDays(10 - i),
                    i * 15));
        }
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }

    public Post findById(Long no) {
        return posts.stream()
                .filter(post -> post.getNo().equals(no))
                .findFirst()
                .map(post -> {
                    post.setViews(post.getViews() + 1);
                    return post;
                })
                .orElse(null);
    }
}
