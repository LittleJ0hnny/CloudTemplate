package com.okravtsiv.authservice.domain.service;

import com.okravtsiv.authservice.domain.model.entity.AuthGrantType;
import com.okravtsiv.authservice.domain.model.entity.Resource;
import com.okravtsiv.authservice.domain.repository.AuthGrantTypeRepository;

import java.util.Set;

public interface AuthGrantTypeService extends Service<AuthGrantType, Long, AuthGrantTypeRepository> {

    Set<AuthGrantType> findByValues(Set<String> values);
}
