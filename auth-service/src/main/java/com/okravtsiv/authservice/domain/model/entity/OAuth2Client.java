package com.okravtsiv.authservice.domain.model.entity;

import com.okravtsiv.authservice.domain.model.AuthGrantTypes;
import com.okravtsiv.authservice.domain.model.Authorities;
import com.okravtsiv.authservice.domain.model.Resources;
import com.okravtsiv.authservice.domain.model.Scopes;
import com.okravtsiv.authservice.util.CollectionMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "oauth2_clients")
public class OAuth2Client implements ClientDetails {
    @Transient
    @Value("token.access.default_time")
    public final Integer DEFAULT_ACCESS_TOKEN_VALIDITY = 1800;

    @Transient
    @Value("token.refresh.default_time")
    public final Integer DEFAULT_REFRESH_TOKEN_VALIDITY = 86400;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String clientId;

    @Column(unique = true, nullable = false)
    private String clientSecret;

    @Column(unique = true)
    private String resourceIds;

    @Column
    private boolean isSecretRequired;

    @Column
    private boolean isScoped;

    @Column
    private String scope;

    @Column(nullable = false)
    private String authorizedGrantTypes;

    @ElementCollection
    private Set<String> registeredRedirectUri;

    @Column
    private String authorities;

    @Column(nullable = false)
    private Integer accessTokenValiditySeconds;

    @Column(nullable = false)
    private Integer refreshTokenValiditySeconds;

    @Column
    private boolean isAutoApprove;

    public OAuth2Client() {
        this.accessTokenValiditySeconds = DEFAULT_ACCESS_TOKEN_VALIDITY;
        this.refreshTokenValiditySeconds = DEFAULT_REFRESH_TOKEN_VALIDITY;
        this.isAutoApprove = true;
    }

    public OAuth2Client(String clientId, String clientSecret, String authorizedGrantTypes) {
        this();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    @Override
    public Set<String> getResourceIds() {
        return CollectionMapper.stringToSet(resourceIds);
    }

    @Override
    public Set<String> getScope() {
        return CollectionMapper.stringToSet(scope);
    }

    public void setScope(Set<Scopes> scopes) {
        this.scope = CollectionMapper.collectionToString(scopes.stream().map(Scopes::getValue).collect(Collectors.toSet()));
    }

    public void setResourceIds(Set<Resources> resources) {
        this.resourceIds = CollectionMapper.collectionToString(resources.stream().map(Resources::getValue).collect(Collectors.toSet()));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return CollectionMapper.stringToSet(authorizedGrantTypes);
    }

    public void setAuthorizedGrantTypes(Set<AuthGrantTypes> authGrantTypes) {
        this.authorizedGrantTypes = CollectionMapper.collectionToString(authGrantTypes.stream().map(AuthGrantTypes::getValue).collect(Collectors.toSet()));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return CollectionMapper.stringToSet(authorities).stream().map(element -> (GrantedAuthority) () -> element).collect(Collectors.toSet());
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = CollectionMapper.collectionToString(authorities.stream().map(Authorities::getValue).collect(Collectors.toSet()));
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return isAutoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>();
    }
}
