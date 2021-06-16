package pl.sda.allegroclone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "orders")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String data;
    @Column
    private String status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PortalUser.class)
    private PortalUser portalUser;
    @OneToMany(mappedBy = "order")
    private Set<OrderElement>orderElements;






}
