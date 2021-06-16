package pl.sda.allegroclone.service;


import pl.sda.allegroclone.model.PortalUser;
import pl.sda.allegroclone.model.dto.UserDTO;

import javax.validation.Valid;
import java.util.List;

public interface UserService {


    List<UserDTO> findAll();

    UserDTO findById(int id);

    UserDTO create(UserDTO userDTO);

    UserDTO update(int id, UserDTO userDTO);

    void delete(int id);

    PortalUser getUserEntity(int id);

    PortalUser findByLogin(String login);

    void save(PortalUser portalUser);

    void register(PortalUser portalUser);
}
