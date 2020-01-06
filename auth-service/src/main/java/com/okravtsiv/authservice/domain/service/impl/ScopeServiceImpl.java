package com.okravtsiv.authservice.domain.service.impl;

import com.okravtsiv.authservice.domain.model.entity.Scope;
import com.okravtsiv.authservice.domain.repository.ScopeRepository;
import com.okravtsiv.authservice.domain.service.AbstractService;
import com.okravtsiv.authservice.domain.service.ScopeService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;

@Primary
@Service
public class ScopeServiceImpl extends AbstractService<Scope, Long, ScopeRepository> implements ScopeService {

    protected ScopeServiceImpl(ScopeRepository repository) {
        super(repository);
    }

    @Override
    public Set<Scope> findByValues(Set<String> values) {
        return repository.findByValueIn(values);
    }
}
