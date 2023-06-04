package dev.ooae.mybatis.mapper;

import dev.ooae.mybatis.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto);
    int createPostAll(List<PostDto> dtoList);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto dto);
    int updatePost(PostDto dto);
    int deletePost(int id);
    //parametertype은 인터페이스 함수에서 받을 인자
    //resulttype은 결과가 돌려줘야하는 인자, 또는 그 인자를 가지고 있는 커넥션의 형태
}
