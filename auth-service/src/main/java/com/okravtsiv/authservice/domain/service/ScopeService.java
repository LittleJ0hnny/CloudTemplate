package com.okravtsiv.authservice.domain.service;

import com.okravtsiv.authservice.domain.model.entity.Scope;
import com.okravtsiv.authservice.domain.repository.ScopeRepository;

import java.util.Set;

public interface ScopeService extends Service<Scope, Long, ScopeRepository> {

    Set<Scope> findByValues(Set<String> values);
}
