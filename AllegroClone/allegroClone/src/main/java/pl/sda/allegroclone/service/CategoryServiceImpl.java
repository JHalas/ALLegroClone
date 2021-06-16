package pl.sda.allegroclone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.allegroclone.model.Category;
import pl.sda.allegroclone.model.dto.CategoryDTO;
import pl.sda.allegroclone.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> modelMapper
                .map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
       categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
       return categoryDTO;
    }

    @Override
    public void delete(int id) {

    }
}
