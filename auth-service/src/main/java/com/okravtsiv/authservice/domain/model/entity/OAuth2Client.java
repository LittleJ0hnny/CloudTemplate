package com.okravtsiv.authservice.domain.model.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "oauth2_clients")
@SequenceGenerator(name = "oauth2client_id_generator", sequenceName = "oauth2_clients_sequence", allocationSize = 1)
public class OAuth2Client implements ClientDetails, Serializable {

    @Transient
    @Value("token.access.default_time")
    public final Integer DEFAULT_ACCESS_TOKEN_VALIDITY = 1800;

    @Transient
    @Value("token.refresh.default_time")
    public final Integer DEFAULT_REFRESH_TOKEN_VALIDITY = 86400;

    @Id
    @GeneratedValue(generator = "oauth2client_id_generator")
    private Long id;

    @Column(unique = true, nullable = false)
    private String clientId;

    @Column(unique = true, nullable = false)
    private String clientSecret;

    @OneToMany
    @JoinTable(
            name = "oauth2client_resources",
            joinColumns = @JoinColumn(
                    name = "oauth2client_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "resource_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Resource> resourceIds;

    @OneToMany
    @JoinTable(
            name = "oauth2client_scopes",
            joinColumns = @JoinColumn(
                    name = "oauth2client_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "scope_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Scope> scopes;

    @OneToMany
    @JoinTable(
            name = "oauth2client_auth_grant_types",
            joinColumns = @JoinColumn(
                    name = "oauth2client_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "auth_grant_type_id",
                    referencedColumnName = "id"
            )
    )
    private Set<AuthGrantType> authorizedGrantTypes;

    @OneToMany
    @JoinTable(
            name = "oauth2client_redirect_uris",
            joinColumns = @JoinColumn(
                    name = "oauth2client_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "uri_id",
                    referencedColumnName = "id"
            )
    )
    private Set<RedirectUri> registeredRedirectUri;

    @OneToMany
    @JoinTable(
            name = "oauth2client_authorities",
            joinColumns = @JoinColumn(
                    name = "oauth2client_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "authority_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Authority> authorities;

    @Column
    private Boolean isSecretRequired;

    @Column
    private Boolean isScoped;

    @Column
    private Boolean isAutoApprove;

    @Column(nullable = false)
    private Integer accessTokenValiditySeconds;

    @Column(nullable = false)
    private Integer refreshTokenValiditySeconds;

    public OAuth2Client() {
        this.accessTokenValiditySeconds = DEFAULT_ACCESS_TOKEN_VALIDITY;
        this.refreshTokenValiditySeconds = DEFAULT_REFRESH_TOKEN_VALIDITY;
        this.isAutoApprove = true;
    }

    public OAuth2Client(String clientId, String clientSecret, Set<AuthGrantType> authorizedGrantTypes) {
        this();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    @Override
    public Collection getAuthorities() {
        return authorities;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes.stream().map(AuthGrantType::getValue).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.registeredRedirectUri.stream().map(RedirectUri::getValue).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getResourceIds() {
        return this.resourceIds.stream().map(Resource::getValue).collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return this.isSecretRequired;
    }

    @Override
    public boolean isScoped() {
        return this.isScoped;
    }

    @Override
    public Set<String> getScope() {
        return scopes.stream().map(Scope::getValue).collect(Collectors.toSet());
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return this.isAutoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
