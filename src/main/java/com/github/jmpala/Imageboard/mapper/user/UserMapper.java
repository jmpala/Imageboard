package com.github.jmpala.Imageboard.mapper.user;

import com.github.jmpala.Imageboard.dao.user.User;
import com.github.jmpala.Imageboard.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

}
