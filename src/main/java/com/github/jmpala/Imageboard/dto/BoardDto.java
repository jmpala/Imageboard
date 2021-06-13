package com.github.jmpala.Imageboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Long id;

    private String fullName;

    private String shortName;

    private boolean isAvailable;

    private boolean isNSFW;

    private List<PostDto> posts;
}
