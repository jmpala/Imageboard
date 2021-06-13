package com.github.jmpala.Imageboard.mapper;

import com.github.jmpala.Imageboard.dao.Comment;
import com.github.jmpala.Imageboard.dto.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto commentToCommentDto(Comment comment);

    Comment CommentDtoToComment(CommentDto commentDto);

}
