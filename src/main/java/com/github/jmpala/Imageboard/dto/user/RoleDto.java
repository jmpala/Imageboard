package com.github.jmpala.Imageboard.dto.user;

import com.github.jmpala.Imageboard.dao.user.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private String role;

    private User user;
}
