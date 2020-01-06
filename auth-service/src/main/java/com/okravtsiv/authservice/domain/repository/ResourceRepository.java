package com.okravtsiv.authservice.domain.repository;

import com.okravtsiv.authservice.domain.model.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Set<Resource> findByValueIs(Set<String> values);

}
