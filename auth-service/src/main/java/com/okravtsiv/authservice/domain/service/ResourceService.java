package com.okravtsiv.authservice.domain.service;

import com.okravtsiv.authservice.domain.model.entity.Resource;
import com.okravtsiv.authservice.domain.repository.ResourceRepository;

import java.util.Set;

public interface ResourceService extends Service<Resource, Long, ResourceRepository> {

    Set<Resource> findByValues(Set<String> values);
}
