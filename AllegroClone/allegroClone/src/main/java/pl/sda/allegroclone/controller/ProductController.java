package pl.sda.allegroclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.allegroclone.model.dto.ProductDTO;
import pl.sda.allegroclone.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }


    @GetMapping("/api/products/{id}")
    public ProductDTO findById(@PathVariable int id) {
        return  productService.findById(id);
    }


    @PostMapping("/api/products")
    public ProductDTO create(@Valid @RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}













