package pl.sda.allegroclone.service;

import pl.sda.allegroclone.model.dto.OrderElementDTO;

import java.util.List;


public interface OrderElementService {

    List<OrderElementDTO> findByOrder(int order_id) ;

}
