package pl.sda.allegroclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.allegroclone.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>  {


}
