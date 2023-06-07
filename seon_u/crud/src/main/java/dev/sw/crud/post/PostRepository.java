package dev.sw.crud.post;

import java.util.List;

public interface PostRepository {
    boolean save(PostDto dto);
    PostDto findById(int id);
    List<PostDto> findAll();
    boolean update(int id, PostDto dto);
    boolean delete(int id);
}
