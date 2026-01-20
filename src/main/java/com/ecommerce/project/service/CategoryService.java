package com.ecommerce.project.service;


import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;



public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    void createCategory(CategoryDTO categoryDTO);

    String deleteCategory(Long categoryId);

    Category updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
