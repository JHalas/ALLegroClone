package pl.sda.allegroclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.allegroclone.model.OrderElement;

import java.util.List;

public interface OrderElementRepository extends JpaRepository<OrderElement, Integer> {

    List<OrderElement> findOrderElementsByOrderId(int order_id);

}
