package com.github.jmpala.Imageboard.service;

import com.github.jmpala.Imageboard.dao.Category;
import com.github.jmpala.Imageboard.dto.CategoryDto;
import com.github.jmpala.Imageboard.mapper.CategoryMapper;
import com.github.jmpala.Imageboard.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList();

        for (Category c : categories) {
            categoryDtos.add(categoryMapper.categoryToCategoryDto(c));
        }
        return categoryDtos;
    }

    @Override
    @Transactional
    public Optional<CategoryDto> findById(Long id) {
        Optional<Category> oCategory = categoryRepository.findById(id);
        if (oCategory.isEmpty())
            return null; // TODO: see what to return to the controller
        Optional<CategoryDto> oCategoryDto = Optional.of(categoryMapper.categoryToCategoryDto(oCategory.get()));
        return oCategoryDto;
    }

    @Override
    @Transactional
    public CategoryDto save(CategoryDto e) {
        Category savedCategory = categoryRepository.save(categoryMapper.categoryDtoToCategory(e));
        return categoryMapper.categoryToCategoryDto(savedCategory);
    }

    @Override
    @Transactional
    public void delete(CategoryDto e) {
        categoryRepository.delete(categoryMapper.categoryDtoToCategory(e));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
