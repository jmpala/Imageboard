package com.github.jmpala.Imageboard.mapper;

import com.github.jmpala.Imageboard.dao.Post;
import com.github.jmpala.Imageboard.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "boardId", ignore = true )
    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);

}
