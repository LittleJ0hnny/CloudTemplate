package com.okravtsiv.authservice.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "auth_grant_types")
@SequenceGenerator(name = "gt_id_generator", sequenceName = "auth_grant_types_sequence", allocationSize = 1)
public class AuthGrantType implements Serializable {

    @Id
    @GeneratedValue(generator = "gt_id_generator")
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public AuthGrantType(String value) {
        this.value = value;
    }
}
