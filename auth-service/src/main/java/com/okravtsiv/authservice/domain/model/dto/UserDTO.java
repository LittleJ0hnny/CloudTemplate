package com.okravtsiv.authservice.domain.model.dto;

import com.okravtsiv.authservice.domain.model.UserBuilder;
import com.okravtsiv.authservice.domain.model.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public User asUser() {
        return new UserBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}
