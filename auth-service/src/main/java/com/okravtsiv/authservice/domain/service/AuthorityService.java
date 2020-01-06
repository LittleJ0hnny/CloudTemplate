package com.okravtsiv.authservice.domain.service;

import com.okravtsiv.authservice.domain.model.entity.Authority;
import com.okravtsiv.authservice.domain.repository.AuthorityRepository;

import java.util.Set;

public interface AuthorityService extends Service<Authority, Long, AuthorityRepository> {

    Set<Authority> findByAuthorityNames(Set<String> names);
}
