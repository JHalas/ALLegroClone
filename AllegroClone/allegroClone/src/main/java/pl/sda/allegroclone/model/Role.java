package pl.sda.allegroclone.model;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude="portalUsers")
@ToString(exclude = "portalUsers")
public class Role {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_rola;
    @Column
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<PortalUser> portalUsers = new HashSet<>();



}
