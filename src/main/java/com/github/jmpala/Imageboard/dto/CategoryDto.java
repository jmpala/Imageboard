package com.github.jmpala.Imageboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;

    private String categoryName;

    private boolean isAvailable;

    private boolean isNSFW;

    private BoardDto boards;
}
