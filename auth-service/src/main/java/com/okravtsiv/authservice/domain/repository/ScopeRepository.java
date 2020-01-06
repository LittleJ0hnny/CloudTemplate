package com.okravtsiv.authservice.domain.repository;

import com.okravtsiv.authservice.domain.model.entity.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ScopeRepository extends JpaRepository<Scope, Long> {

    Set<Scope> findByValueIn(Set<String> values);
}
