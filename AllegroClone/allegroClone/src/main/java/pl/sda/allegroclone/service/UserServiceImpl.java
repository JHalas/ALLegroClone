package pl.sda.allegroclone.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.sda.allegroclone.exception.UserAlreadyException;
import pl.sda.allegroclone.exception.UserNotFoundException;
import pl.sda.allegroclone.model.PortalUser;
import pl.sda.allegroclone.model.Role;
import pl.sda.allegroclone.model.dto.UserDTO;
import pl.sda.allegroclone.repository.OrderRepository;
import pl.sda.allegroclone.repository.RoleRepository;
import pl.sda.allegroclone.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;


    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream().map(user -> modelMapper
                        .map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(int id) {
        return modelMapper
                .map(userRepository.findById(id)
                        .orElseThrow(UserNotFoundException::new), UserDTO.class);
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, PortalUser.class));
        return userDTO;

    }

    @Override
    public UserDTO update(int id, UserDTO userDTO) {
        PortalUser portalUser = getUserEntity(id);
        if (userDTO.getFirstName() != null) {
            portalUser.setFirstName(userDTO.getFirstName());
        }
        if (userDTO.getLastName() != null) {
            portalUser.setLastName(userDTO.getLastName());
        }
        if (userDTO.getEmail() != null) {
            portalUser.setEmail(userDTO.getEmail());
        }
        if (userDTO.getAddress() != null) {
            portalUser.setAddress(userDTO.getAddress());
        }
        return modelMapper.map(userRepository.save(portalUser), UserDTO.class);
    }

    @Override
    public void delete(int id) {
        PortalUser portalUser = getUserEntity(id);
        orderRepository.deleteAll(portalUser.getOrders());
        userRepository.deleteById(id);


    }

    @Override
    public void save(PortalUser portalUser) {
        portalUser.setPassword(passwordEncoder.encode(portalUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        portalUser.setRoles(roles);
        userRepository.save(portalUser);
    }

    @Override
    public PortalUser getUserEntity(int id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public PortalUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    @Override
    public void register(PortalUser portalUser) {
        if (checkIfUserExist(portalUser.getLogin())) {
            throw new UserAlreadyException();
        }
        passwordEncoder.encode((passwordEncoder.encode(portalUser.getPassword())));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        portalUser.setRoles(roles);
        userRepository.save(portalUser);


    }

    private boolean checkIfUserExist(String login) {
        return userRepository.findByLogin(login) != null;
    }


}

