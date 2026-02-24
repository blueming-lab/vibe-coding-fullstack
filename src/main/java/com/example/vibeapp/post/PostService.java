package com.example.vibeapp.post;

import com.example.vibeapp.post.dto.PostCreateDto;
import com.example.vibeapp.post.dto.PostListDto;
import com.example.vibeapp.post.dto.PostResponseDto;
import com.example.vibeapp.post.dto.PostUpdateDto;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostListDto> getPostsByPage(int page, int size) {
        List<Post> allPosts = postRepository.findAll();
        allPosts.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));

        int fromIndex = (page - 1) * size;
        if (allPosts.size() <= fromIndex) {
            return List.of();
        }

        List<Post> pagedPosts = allPosts.subList(fromIndex, Math.min(fromIndex + size, allPosts.size()));
        return pagedPosts.stream()
                .map(PostListDto::from)
                .collect(Collectors.toList());
    }

    public int getTotalPages(int size) {
        int totalPosts = postRepository.findAll().size();
        return (int) Math.ceil((double) totalPosts / size);
    }

    public PostResponseDto getPost(Long no) {
        Post post = postRepository.findById(no);
        return post != null ? PostResponseDto.from(post) : null;
    }

    public void createPost(PostCreateDto createDto) {
        Post post = createDto.toEntity();
        postRepository.save(post);
    }

    public void updatePost(Long no, PostUpdateDto updateDto) {
        Post post = postRepository.findById(no);
        if (post != null) {
            updateDto.updateEntity(post);
            postRepository.update(no, post.getTitle(), post.getContent());
        }
    }

    public void deletePost(Long no) {
        postRepository.delete(no);
    }
}
