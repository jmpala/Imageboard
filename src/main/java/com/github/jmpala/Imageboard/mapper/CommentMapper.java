package com.github.jmpala.Imageboard.mapper;

import com.github.jmpala.Imageboard.dao.Comment;
import com.github.jmpala.Imageboard.dto.CommentDto;
import com.github.jmpala.Imageboard.repository.PostRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {

    @Autowired
    private PostRepository postRepository;

    public CommentDto commentToCommentDto(Comment comment) {
        if(comment == null) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setCreated(comment.getCreated());
        commentDto.setAttachment(comment.getAttachment());
        commentDto.setMessage(comment.getMessage());
        commentDto.setPostId(comment.getPost().getId());

        return commentDto;
    }

    public Comment CommentDtoToComment(CommentDto commentDto) {
        if(commentDto == null) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setCreated(commentDto.getCreated());
        comment.setAttachment(commentDto.getAttachment());
        comment.setMessage(commentDto.getMessage());
        comment.setPost(postRepository.getById(commentDto.getPostId()));

        return comment;
    }

}
