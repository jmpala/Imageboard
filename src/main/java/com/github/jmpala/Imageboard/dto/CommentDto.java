package com.github.jmpala.Imageboard.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;

    private Date created;

    private String attachment;

    private String message;

    private Long postId;
}
