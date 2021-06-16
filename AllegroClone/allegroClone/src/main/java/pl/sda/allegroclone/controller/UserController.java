package pl.sda.allegroclone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pl.sda.allegroclone.model.dto.UserDTO;
import pl.sda.allegroclone.service.UserService;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/api/users/{id}")
    public UserDTO findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDTO create(@Valid @RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PostMapping("/api/users/{id}")
    public UserDTO update(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.update(id, userDTO);
    }

    @DeleteMapping("/api/users/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);

    }
}


    

