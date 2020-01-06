package com.okravtsiv.authservice.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "scopes")
@SequenceGenerator(name = "scope_id_generator", sequenceName = "scopes_sequence", allocationSize = 1)
public class Scope implements Serializable {

    @Id
    @GeneratedValue(generator = "scope_id_generator")
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public Scope(String value) {
        this.value = value;
    }
}
