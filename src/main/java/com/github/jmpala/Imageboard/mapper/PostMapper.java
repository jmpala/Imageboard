package com.github.jmpala.Imageboard.mapper;

import com.github.jmpala.Imageboard.dao.Comment;
import com.github.jmpala.Imageboard.dao.Post;
import com.github.jmpala.Imageboard.dto.CommentDto;
import com.github.jmpala.Imageboard.dto.PostDto;
import com.github.jmpala.Imageboard.repository.BoardRepository;
import com.github.jmpala.Imageboard.repository.CommentRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    public PostDto postToPostDto(Post post) {
        if(post == null) {
            return null;
        }

        PostDto postDto = new PostDto();
        postDto.setComments(new ArrayList<>());

        postDto.setId(post.getId());
        postDto.setPhotoPath(post.getPhotoPath());
        postDto.setTitle(post.getTitle());
        postDto.setBody(post.getBody());

        for (Comment comment: post.getComments()) {
            postDto.getComments().add(commentMapper.commentToCommentDto(comment));
        }

        return postDto;
    }

    public Post postDtoToPost(PostDto postDto) {
        if(postDto == null) {
            return null;
        }

        Post post = new Post();
        post.setComments(new ArrayList<>());

        post.setId(postDto.getId());
        post.setCreated(postDto.getCreated());
        post.setPhotoPath(postDto.getPhotoPath());
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());

        for (CommentDto commentDto: postDto.getComments()) {
            post.getComments().add(commentMapper.CommentDtoToComment(commentDto));
        }

        return post;
    }

}
