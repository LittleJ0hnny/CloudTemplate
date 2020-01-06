package com.okravtsiv.authservice.domain.repository;

import com.okravtsiv.authservice.domain.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Set<Authority> findByAuthorityIn(Set<String> values);
}
