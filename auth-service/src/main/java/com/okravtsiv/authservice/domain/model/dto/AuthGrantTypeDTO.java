package com.okravtsiv.authservice.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthGrantTypeDTO {

    private Long id;

    private String grantType;

    public AuthGrantTypeDTO(String grantType) {
        this.grantType = grantType;
    }
}
