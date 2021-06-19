package com.github.jmpala.Imageboard.mapper.user;

import com.github.jmpala.Imageboard.dao.user.Role;
import com.github.jmpala.Imageboard.dto.user.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto roleToRoleDto(Role role);

    Role roleDtoToRole(RoleDto roleDto);
}
