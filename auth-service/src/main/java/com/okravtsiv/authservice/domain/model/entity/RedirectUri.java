package com.okravtsiv.authservice.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "redirect_uris")
@SequenceGenerator(name = "redirect_id_generator", sequenceName = "redirect_uris_sequence", allocationSize = 1)
public class RedirectUri implements Serializable {

    @Id
    @GeneratedValue(generator = "redirect_id_generator")
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public RedirectUri(String value) {
        this.value = value;
    }
}
