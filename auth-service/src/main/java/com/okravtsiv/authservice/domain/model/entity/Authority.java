package com.okravtsiv.authservice.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "authorities")
@SequenceGenerator(name = "authority_id_generator", sequenceName = "authorities_sequence", allocationSize = 1)
public class Authority implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(generator = "authority_id_generator")
    private Long id;

    @Column(unique = true, nullable = false)
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }
}
