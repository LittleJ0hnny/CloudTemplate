package com.okravtsiv.authservice.domain.service;

import com.okravtsiv.authservice.domain.model.entity.OAuth2Client;
import com.okravtsiv.authservice.domain.repository.OAuth2ClientRepository;

public interface OAuth2ClientService extends Service<OAuth2Client, Long, OAuth2ClientRepository> {
}
