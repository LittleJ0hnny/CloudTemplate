package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.dto.UserDTO;
import com.okravtsiv.authservice.domain.model.mappers.UserMapper;
import com.okravtsiv.authservice.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        userService.save(UserMapper.INSTANCE.dtoToEntity(userDTO));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
