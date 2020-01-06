package com.okravtsiv.authservice.domain.service.impl;

import com.okravtsiv.authservice.domain.model.entity.Authority;
import com.okravtsiv.authservice.domain.repository.AuthorityRepository;
import com.okravtsiv.authservice.domain.service.AbstractService;
import com.okravtsiv.authservice.domain.service.AuthorityService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;

@Primary
@Service
public class AuthorityServiceImpl extends AbstractService<Authority, Long, AuthorityRepository> implements AuthorityService {

    protected AuthorityServiceImpl(AuthorityRepository repository) {
        super(repository);
    }

    @Override
    public Set<Authority> findByAuthorityNames(Set<String> names) {
        return repository.findByAuthorityIn(names);
    }
}
