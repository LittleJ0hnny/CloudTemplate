package com.okravtsiv.authservice.domain.model;

import com.okravtsiv.authservice.domain.model.entity.OAuth2Client;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class OAuth2ClientBuilder {
    private OAuth2Client oAuth2Client;

    public OAuth2ClientBuilder() {
        oAuth2Client = new OAuth2Client();
    }

    public OAuth2ClientBuilder setId(Long id) {
        oAuth2Client.setId(id);
        return this;
    }

    public OAuth2ClientBuilder setClientId(String clientId) {
        oAuth2Client.setClientId(clientId);
        return this;
    }

    public OAuth2ClientBuilder setResources(Set<Resources> resourceIds) {
        oAuth2Client.setResourceIds(resourceIds);
        return this;
    }

    public OAuth2ClientBuilder setSecretRequired(boolean secretRequired) {
        oAuth2Client.setSecretRequired(secretRequired);
        return this;
    }

    public OAuth2ClientBuilder setClientSecret(String clientSecret) {
        oAuth2Client.setClientSecret(clientSecret);
        return this;
    }

    public OAuth2ClientBuilder setScoped(boolean scoped) {
        oAuth2Client.setScoped(scoped);
        return this;
    }

    public OAuth2ClientBuilder setScope(Set<Scopes> scope) {
        oAuth2Client.setScope(scope);
        return this;
    }

    public OAuth2ClientBuilder setGrantTypes(Set<AuthGrantTypes> authorizedGrantTypes) {
        oAuth2Client.setAuthorizedGrantTypes(authorizedGrantTypes);
        return this;
    }

    public OAuth2ClientBuilder setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        oAuth2Client.setRegisteredRedirectUri(registeredRedirectUri);
        return this;
    }

    public OAuth2ClientBuilder setAuthorities(List<Authorities> authorities) {
        oAuth2Client.setAuthorities(authorities);
        return this;
    }

    public OAuth2ClientBuilder setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        oAuth2Client.setAccessTokenValiditySeconds(Optional.ofNullable(accessTokenValiditySeconds).orElse(oAuth2Client.DEFAULT_ACCESS_TOKEN_VALIDITY));
        return this;
    }

    public OAuth2ClientBuilder setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        oAuth2Client.setRefreshTokenValiditySeconds(Optional.ofNullable(refreshTokenValiditySeconds).orElse(oAuth2Client.DEFAULT_REFRESH_TOKEN_VALIDITY));
        return this;
    }

    public OAuth2ClientBuilder setAutoApprove(boolean autoApprove) {
        oAuth2Client.setAutoApprove(autoApprove);
        return this;
    }

    public OAuth2Client build() {
        return oAuth2Client;
    }
}
