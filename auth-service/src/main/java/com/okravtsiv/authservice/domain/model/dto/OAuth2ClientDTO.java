package com.okravtsiv.authservice.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class OAuth2ClientDTO {
    private Long id;
    private String clientId;
    private String clientSecret;
    private Set<String> resourceIds;
    private Set<String> scopes;
    private Set<String> authorizedGrantTypes;
    private Set<String> registeredRedirectUri;
    private Set<String> authorities;
    private Boolean isSecretRequired;
    private Boolean isScoped;
    private Boolean isAutoApprove;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    public OAuth2ClientDTO(String clientId, String clientSecret, Set<String> authorities) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorities = authorities;
    }
}
