package pl.sda.allegroclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor

public class OrderElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer quantitiy;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @ManyToOne(targetEntity = Order.class)
    private Order order;


}
