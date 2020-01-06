package com.okravtsiv.authservice.domain.service.impl;

import com.okravtsiv.authservice.domain.model.entity.AuthGrantType;
import com.okravtsiv.authservice.domain.model.entity.Resource;
import com.okravtsiv.authservice.domain.repository.AuthGrantTypeRepository;
import com.okravtsiv.authservice.domain.service.AbstractService;
import com.okravtsiv.authservice.domain.service.AuthGrantTypeService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;

@Primary
@Service
public class AuthGrantTypeServiceImpl extends AbstractService<AuthGrantType, Long, AuthGrantTypeRepository> implements AuthGrantTypeService {

    protected AuthGrantTypeServiceImpl(AuthGrantTypeRepository repository) {
        super(repository);
    }

    @Override
    public Set<AuthGrantType> findByValues(Set<String> values) {
        return repository.findByValueIn(values);
    }
}
