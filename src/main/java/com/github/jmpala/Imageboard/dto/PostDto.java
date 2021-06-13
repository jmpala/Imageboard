package com.github.jmpala.Imageboard.dto;

import com.github.jmpala.Imageboard.dao.Board;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;

    private Date created;

    private Byte[] photo;

    private String title;

    private String body;

    private Board boardDto;

    private List<CommentDto> comments;
}
