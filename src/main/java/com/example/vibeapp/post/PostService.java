package com.example.vibeapp.post;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPostsByPage(int page, int size) {
        List<Post> allPosts = postRepository.findAll();
        allPosts.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));

        int fromIndex = (page - 1) * size;
        if (allPosts.size() <= fromIndex) {
            return List.of();
        }

        return allPosts.subList(fromIndex, Math.min(fromIndex + size, allPosts.size()));
    }

    public int getTotalPages(int size) {
        int totalPosts = postRepository.findAll().size();
        return (int) Math.ceil((double) totalPosts / size);
    }

    public Post getPostByNo(Long no) {
        return postRepository.findById(no);
    }

    public void createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(null);
        post.setViews(0);
        postRepository.save(post);
    }

    public void updatePost(Long no, String title, String content) {
        postRepository.update(no, title, content);
    }

    public void deletePost(Long no) {
        postRepository.delete(no);
    }
}
