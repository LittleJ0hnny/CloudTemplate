package com.okravtsiv.authservice.domain.service.impl;

import com.okravtsiv.authservice.domain.model.entity.Resource;
import com.okravtsiv.authservice.domain.repository.ResourceRepository;
import com.okravtsiv.authservice.domain.service.AbstractService;
import com.okravtsiv.authservice.domain.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;

@Primary
@Service
public class ResourceServiceImpl extends AbstractService<Resource, Long, ResourceRepository> implements ResourceService {

    @Autowired
    protected ResourceServiceImpl(ResourceRepository repository) {
        super(repository);
    }

    @Override
    public Set<Resource> findByValues(Set<String> values) {
        return repository.findByValueIs(values);
    }
}
