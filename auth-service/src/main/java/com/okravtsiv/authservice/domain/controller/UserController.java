package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.Authorities;
import com.okravtsiv.authservice.domain.model.dto.UserDTO;
import com.okravtsiv.authservice.domain.model.entity.User;
import com.okravtsiv.authservice.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        Set<Authorities> authorities = new HashSet<>();
        authorities.add(Authorities.USER);
        User user = userDTO.asUser();
        user.setAuthorities(authorities);
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
