package pl.sda.allegroclone.service;

import pl.sda.allegroclone.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll();
    CategoryDTO create(CategoryDTO categoryDTO);
    void delete(int id);

}
