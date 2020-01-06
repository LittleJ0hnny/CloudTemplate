package com.okravtsiv.authservice.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "resources")
@SequenceGenerator(name = "resource_id_generator", sequenceName = "resources_sequence", allocationSize = 1)
public class Resource implements Serializable {

    @Id
    @GeneratedValue(generator = "resource_id_generator")
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public Resource(String value) {
        this.value = value;
    }
}
