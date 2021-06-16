package pl.sda.allegroclone.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.sda.allegroclone.exception.OrderNotFoundException;
import pl.sda.allegroclone.model.Order;
import pl.sda.allegroclone.model.dto.OrderDTO;
import pl.sda.allegroclone.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private  final ModelMapper modelMapper;

    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(order -> modelMapper
                        .map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public OrderDTO findById(int id) {
        return modelMapper.
                map(orderRepository.findById(id)
                        .orElseThrow(OrderNotFoundException::new), OrderDTO.class);

    }


    @Override
    public List<OrderDTO> findByUserId(int portalUser_id) {
        return orderRepository.findOrderByPortalUserId(portalUser_id)
                .stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        orderRepository.save(modelMapper.map(orderDTO, Order.class));
        return  orderDTO;
    }

    @Override
    public void delete(int id) {
        Order order = getOrderEntity(id);
        orderRepository.deleteById(id);
    }

    @Override
    public Order getOrderEntity(int id){
        return orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
    }

}
