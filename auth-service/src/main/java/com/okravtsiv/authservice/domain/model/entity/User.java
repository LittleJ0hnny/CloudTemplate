package com.okravtsiv.authservice.domain.model.entity;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_id_generator", sequenceName = "users_sequence", allocationSize = 1)
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "user_id_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "authority_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Authority> authorities;

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

    public User(String username, String password, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isEnabled = true;
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
