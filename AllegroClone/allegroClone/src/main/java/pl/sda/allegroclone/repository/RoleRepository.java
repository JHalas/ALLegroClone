package pl.sda.allegroclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.allegroclone.model.Role;

public interface RoleRepository extends JpaRepository <Role, Integer>{
    Role findByName(String name);
}
