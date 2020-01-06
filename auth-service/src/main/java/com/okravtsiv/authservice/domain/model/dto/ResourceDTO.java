package com.okravtsiv.authservice.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceDTO {

    private Long id;

    private String resource;

    public ResourceDTO(String resource) {
        this.resource = resource;
    }
}
