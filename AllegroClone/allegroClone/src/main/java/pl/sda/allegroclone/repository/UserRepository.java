package pl.sda.allegroclone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.allegroclone.model.PortalUser;


public interface UserRepository extends JpaRepository<PortalUser, Integer> {

    PortalUser findByLogin(String login);

}
