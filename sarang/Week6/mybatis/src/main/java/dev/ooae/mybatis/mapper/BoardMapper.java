package dev.ooae.mybatis.mapper;

import dev.ooae.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
