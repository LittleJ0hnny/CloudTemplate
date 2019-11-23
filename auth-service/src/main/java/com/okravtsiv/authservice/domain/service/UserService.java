package com.okravtsiv.authservice.domain.service;

import com.okravtsiv.authservice.domain.model.entity.User;
import com.okravtsiv.authservice.domain.repository.UserRepository;

public interface UserService extends Service<User, Long, UserRepository> {
    void deleteById(Long id);
}
