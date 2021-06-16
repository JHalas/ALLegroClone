package pl.sda.allegroclone.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.sda.allegroclone.model.dto.OrderElementDTO;
import pl.sda.allegroclone.repository.OrderElementRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderElementServiceImpl implements OrderElementService {

    private final ModelMapper modelMapper;
    private final OrderElementRepository orderElementRepository;


    @Override
    public List<OrderElementDTO> findByOrder(int order_id) {
       return orderElementRepository.findOrderElementsByOrderId(order_id)
                .stream().map(orderElement -> modelMapper.map(orderElement, OrderElementDTO.class))
                .collect(Collectors.toList());
    }

}
