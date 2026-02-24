package com.example.vibeapp.post;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PostRepository {

    List<Post> findAll();

    Post findById(Long no);

    void save(Post post);

    void update(@Param("no") Long no, @Param("title") String title, @Param("content") String content);

    void delete(@Param("no") Long no);

    List<Post> findPaged(@Param("offset") int offset, @Param("size") int size);

    int count();
}
