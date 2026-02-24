package com.example.vibeapp.post;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostTagRepository {
    void save(PostTag postTag);

    void delete(@Param("id") Long id);

    void deleteByPostNo(@Param("postNo") Long postNo);

    java.util.List<PostTag> findByPostNo(@Param("postNo") Long postNo);
}
