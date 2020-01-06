package com.okravtsiv.authservice.domain.service;

import com.okravtsiv.authservice.domain.model.entity.RedirectUri;
import com.okravtsiv.authservice.domain.repository.RedirectUriRepository;

import java.util.Set;

public interface RedirectUriService extends Service<RedirectUri, Long, RedirectUriRepository> {

    Set<RedirectUri> findByValues(Set<String> values);
}
