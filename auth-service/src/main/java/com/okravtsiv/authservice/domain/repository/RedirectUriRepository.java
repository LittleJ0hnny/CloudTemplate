package com.okravtsiv.authservice.domain.repository;

import com.okravtsiv.authservice.domain.model.entity.RedirectUri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface RedirectUriRepository extends JpaRepository<RedirectUri, Long> {

    Set<RedirectUri> findByValueIn(Set<String> values);
}
