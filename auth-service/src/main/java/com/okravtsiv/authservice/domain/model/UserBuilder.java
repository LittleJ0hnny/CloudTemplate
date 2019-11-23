package com.okravtsiv.authservice.domain.model;

import com.okravtsiv.authservice.domain.model.entity.User;

import java.util.Set;

public class UserBuilder {
    private User user;

    public UserBuilder() {
        user = new User();
    }

    public UserBuilder setId(Long id) {
        user.setId(id);
        return this;
    }

    public UserBuilder setAuthorities(Set<Authorities> authorities) {
        user.setAuthorities(authorities);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setUsername(String username) {
        user.setUsername(username);
        return this;
    }

    public UserBuilder setExpired(boolean expired) {
        user.setExpired(expired);
        return this;
    }

    public UserBuilder setLocked(boolean locked) {
        user.setLocked(locked);
        return this;
    }

    public UserBuilder setCredentialsExpired(boolean credentialsExpired) {
        user.setCredentialsExpired(credentialsExpired);
        return this;
    }

    public UserBuilder setEnabled(boolean enabled) {
        user.setEnabled(enabled);
        return this;
    }

    public User build() {
        return user;
    }
}
