package dev.ooae.community.repository;


import dev.ooae.community.model.PostDto;

import java.util.Collection;

public interface PostRepository {
    PostDto create(Long boardId, PostDto dto);
    PostDto read(Long boardId, Long postId);
    Collection<PostDto> readAll(Long boardId);
    boolean update(Long boardId, Long postId, PostDto dto);
    boolean delete(Long boardId, Long postId, String password);
}
