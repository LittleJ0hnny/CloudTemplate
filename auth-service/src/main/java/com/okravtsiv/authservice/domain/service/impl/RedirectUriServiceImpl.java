package com.okravtsiv.authservice.domain.service.impl;

import com.okravtsiv.authservice.domain.model.entity.RedirectUri;
import com.okravtsiv.authservice.domain.repository.RedirectUriRepository;
import com.okravtsiv.authservice.domain.service.AbstractService;
import com.okravtsiv.authservice.domain.service.RedirectUriService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;

@Primary
@Service
public class RedirectUriServiceImpl extends AbstractService<RedirectUri, Long, RedirectUriRepository> implements RedirectUriService {

    protected RedirectUriServiceImpl(RedirectUriRepository repository) {
        super(repository);
    }

    @Override
    public Set<RedirectUri> findByValues(Set<String> values) {
        return repository.findByValueIn(values);
    }
}
