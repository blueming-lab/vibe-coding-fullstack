package com.example.vibeapp.post;

import com.example.vibeapp.post.dto.PostCreateDto;
import com.example.vibeapp.post.dto.PostListDto;
import com.example.vibeapp.post.dto.PostResponseDto;
import com.example.vibeapp.post.dto.PostUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostTagRepository postTagRepository;

    public PostService(PostRepository postRepository, PostTagRepository postTagRepository) {
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
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
        if (post == null)
            return null;

        List<PostTag> tags = postTagRepository.findByPostNo(no);
        String tagsString = tags.stream()
                .map(PostTag::getTagName)
                .collect(Collectors.joining(", "));

        return PostResponseDto.from(post, tagsString);
    }

    @Transactional
    public void createPost(PostCreateDto createDto) {
        Post post = createDto.toEntity();
        postRepository.save(post);

        if (createDto.tags() != null && !createDto.tags().isBlank()) {
            saveTags(post.getNo(), createDto.tags());
        }
    }

    private void saveTags(Long postNo, String tagsString) {
        String[] tags = tagsString.split(",");
        for (String tagName : tags) {
            String trimmedTag = tagName.trim();
            if (!trimmedTag.isEmpty()) {
                PostTag postTag = new PostTag();
                postTag.setPostNo(postNo);
                postTag.setTagName(trimmedTag);
                postTag.setId(null); // id is auto-increment
                postTagRepository.save(postTag);
            }
        }
    }

    @Transactional
    public void updatePost(Long no, PostUpdateDto updateDto) {
        Post post = postRepository.findById(no);
        if (post != null) {
            updateDto.updateEntity(post);
            postRepository.update(no, post.getTitle(), post.getContent());

            postTagRepository.deleteByPostNo(no);
            if (updateDto.tags() != null && !updateDto.tags().isBlank()) {
                saveTags(no, updateDto.tags());
            }
        }
    }

    public void deletePost(Long no) {
        postRepository.delete(no);
    }
}
