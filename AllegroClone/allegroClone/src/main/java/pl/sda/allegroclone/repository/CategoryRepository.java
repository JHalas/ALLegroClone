package pl.sda.allegroclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.allegroclone.model.Category;


public interface CategoryRepository extends JpaRepository<Category , Integer> {


}
