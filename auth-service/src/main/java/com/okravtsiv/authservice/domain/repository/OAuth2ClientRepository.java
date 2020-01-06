package com.okravtsiv.authservice.domain.repository;

import com.okravtsiv.authservice.domain.model.entity.OAuth2Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OAuth2ClientRepository extends JpaRepository<OAuth2Client, Long> {
    OAuth2Client findOAuth2ClientByClientId(String clientId);
}
