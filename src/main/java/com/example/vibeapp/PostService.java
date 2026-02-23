package com.example.vibeapp;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        posts.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));
        return posts;
    }

    public Post getPostByNo(Long no) {
        return postRepository.findById(no);
    }
}
