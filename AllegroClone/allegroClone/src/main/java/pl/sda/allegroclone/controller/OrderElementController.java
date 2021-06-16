package pl.sda.allegroclone.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.allegroclone.model.dto.OrderElementDTO;
import pl.sda.allegroclone.service.OrderElementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderElementController {

    private final OrderElementService orderElementService;

    @GetMapping("/api/orders/{order_id}")
    public List<OrderElementDTO> findByOrderId (@PathVariable int order_id) {
        return orderElementService.findByOrder(order_id);
    }

}
