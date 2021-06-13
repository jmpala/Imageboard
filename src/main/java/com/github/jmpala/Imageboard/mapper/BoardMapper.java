package com.github.jmpala.Imageboard.mapper;

import com.github.jmpala.Imageboard.dao.Board;
import com.github.jmpala.Imageboard.dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardDto boardToBoardDto(Board board);

    Board boardDtoToBoard(BoardDto boardDto);

}
