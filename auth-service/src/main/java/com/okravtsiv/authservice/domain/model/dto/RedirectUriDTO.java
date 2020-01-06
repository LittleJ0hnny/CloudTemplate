package com.okravtsiv.authservice.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RedirectUriDTO {

    private Long id;

    private String redirectUri;

    public RedirectUriDTO(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
