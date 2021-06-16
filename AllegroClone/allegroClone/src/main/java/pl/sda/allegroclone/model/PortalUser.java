package pl.sda.allegroclone.model;


import lombok.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="roles")
@ToString(exclude = "roles")
public class PortalUser {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id ;
    @Column
    private String login;
    @Column
    private String firstName ;
    @Column
    private String lastName ;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles;
    @OneToMany(mappedBy = "portalUser")
    private Set<Order>orders;










}
