package pl.sda.allegroclone.service;

import pl.sda.allegroclone.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

   List <ProductDTO> findAll();
   ProductDTO findById(int id);
   ProductDTO create(ProductDTO productDTO);
   void delete(int id);
}
