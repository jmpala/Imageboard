package com.github.jmpala.Imageboard.mapper;

import com.github.jmpala.Imageboard.dao.Post;
import com.github.jmpala.Imageboard.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);

}
