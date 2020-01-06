package com.okravtsiv.authservice.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScopeDTO {

    private Long id;

    private String scope;

    public ScopeDTO(String scope) {
        this.scope = scope;
    }
}
