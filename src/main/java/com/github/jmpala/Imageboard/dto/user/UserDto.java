package com.github.jmpala.Imageboard.dto.user;

import com.github.jmpala.Imageboard.dao.user.Role;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userName;

    private String password;

    private List<Role> role;

    private boolean enabled;

}
