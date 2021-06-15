package com.github.jmpala.Imageboard.mapper;


import com.github.jmpala.Imageboard.dao.Category;
import com.github.jmpala.Imageboard.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto (Category category);

    Category categoryDtoToCategory (CategoryDto categoryDto);
}
