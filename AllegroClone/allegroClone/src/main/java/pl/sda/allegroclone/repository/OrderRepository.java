package pl.sda.allegroclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.allegroclone.model.Order;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {

   List <Order> findOrderByPortalUserId(int portalUser_id);

}
