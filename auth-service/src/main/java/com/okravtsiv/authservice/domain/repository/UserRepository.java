package com.okravtsiv.authservice.domain.repository;

import com.okravtsiv.authservice.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    void deleteById(Long id);
}
