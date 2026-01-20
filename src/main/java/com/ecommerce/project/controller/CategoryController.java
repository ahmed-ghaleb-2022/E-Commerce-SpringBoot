package com.ecommerce.project.controller;
import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/api/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE) Integer pageSize ,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_CATEGORIES_BY) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR) String sortOrder){

        CategoryResponse allCategories = categoryService.getAllCategories(pageNumber,pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(allCategories, HttpStatus.OK) ;

    }

    @PostMapping("api/public/categories")
    public ResponseEntity<String>  createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>("Added successfully!!", HttpStatus.CREATED) ;
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK) ;

    }


    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId){
        Category updatedCategory = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>("Category with id: "+ categoryId +" updated successfuly", HttpStatus.OK);
    }
}
