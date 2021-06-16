package pl.sda.allegroclone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.allegroclone.exception.ProductNotFoundException;
import pl.sda.allegroclone.model.Product;
import pl.sda.allegroclone.model.dto.ProductDTO;
import pl.sda.allegroclone.repository.CategoryRepository;
import pl.sda.allegroclone.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class ProductServiceImpl implements ProductService {

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        ModelMapper modelMapper;

        @Autowired
        CategoryRepository categoryRepository;

    @Override
        public List<ProductDTO> findAll() {
            return productRepository.findAll()
                    .stream()
                    .map(product -> modelMapper
                            .map(product,ProductDTO.class))
                    .collect(Collectors.toList());

        }

    @Override
    public ProductDTO findById(int id) {
        return modelMapper.map(productRepository.findById(id).orElseThrow(ProductNotFoundException::new), ProductDTO.class);
    }


    @Override
    public ProductDTO create(ProductDTO productDTO) {
        productRepository.save(modelMapper.map(productDTO, Product.class));
        return productDTO;
    }

  @Override
    public void delete(int id) {
            Product product = getProductEntity(id);
            productRepository.deleteById(id);

    }

    private Product getProductEntity(int id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }


}




