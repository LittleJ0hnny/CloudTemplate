package com.okravtsiv.authservice.domain.model.entity;

import com.okravtsiv.authservice.domain.model.Authorities;
import com.okravtsiv.authservice.util.CollectionMapper;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String authorities;

    @Column(nullable = false)
    private boolean isExpired;

    @Column(nullable = false)
    private boolean isLocked;

    @Column(nullable = false)
    private boolean isCredentialsExpired;

    @Column(nullable = false)
    private boolean isEnabled;

    public User() {
        this.isEnabled = true;
    }

    public User(String username, String password, String authorities) {
        this();
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return CollectionMapper.stringToSet(authorities).stream().map(element -> (GrantedAuthority) () -> element).collect(Collectors.toSet());
    }

    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = CollectionMapper.collectionToString(authorities.stream().map(Authorities::getValue).collect(Collectors.toSet()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired;
    }
}
