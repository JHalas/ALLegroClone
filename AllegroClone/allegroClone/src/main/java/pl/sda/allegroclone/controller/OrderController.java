package pl.sda.allegroclone.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.allegroclone.model.dto.OrderDTO;
import pl.sda.allegroclone.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class OrderController {



    private final OrderService orderService ;

    @GetMapping("/api/orders")
    public List<OrderDTO> findALL() { return orderService.findAll(); }

    @GetMapping("/api/orders/{id}")
    public OrderDTO findById(@PathVariable int id) {
        return  orderService.findById(id);
    }

    @GetMapping("/api/orders/user/{user_id}")
    public List<OrderDTO> findByUserId(@PathVariable int user_id) {
        return orderService.findByUserId(user_id);
    }

    @PostMapping("/api/orders")
    public  OrderDTO create(@Valid @RequestBody OrderDTO orderDTO) {
        return  orderService.create(orderDTO);
    }
}
