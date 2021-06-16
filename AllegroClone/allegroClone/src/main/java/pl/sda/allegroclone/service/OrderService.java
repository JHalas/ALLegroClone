package pl.sda.allegroclone.service;

import pl.sda.allegroclone.model.Order;
import pl.sda.allegroclone.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAll();
    OrderDTO findById(int id);
    List<OrderDTO> findByUserId(int portalUser_id);
    OrderDTO create(OrderDTO orderDTO);
    void delete(int id);
    Order getOrderEntity(int id);

}
