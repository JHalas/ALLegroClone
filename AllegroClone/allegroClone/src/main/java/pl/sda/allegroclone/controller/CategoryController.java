package pl.sda.allegroclone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.allegroclone.model.dto.CategoryDTO;
import pl.sda.allegroclone.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping( "/api/categories/")
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }


    @PostMapping( "/api/categories/")
    public CategoryDTO create(@Valid @RequestBody CategoryDTO categoryDTO) {
        return categoryService.create(categoryDTO);
    }
}
