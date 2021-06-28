package com.github.jmpala.Imageboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;

    private Date created;

    private String photo;

    private String title;

    private String body;

    private BoardDto boardDto;

    private Long boardId;

    private List<CommentDto> comments;
}
