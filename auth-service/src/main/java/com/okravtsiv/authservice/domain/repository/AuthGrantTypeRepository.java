package com.okravtsiv.authservice.domain.repository;

import com.okravtsiv.authservice.domain.model.entity.AuthGrantType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthGrantTypeRepository extends JpaRepository<AuthGrantType, Long> {

    Set<AuthGrantType> findByValueIn(Set<String> values);
}
