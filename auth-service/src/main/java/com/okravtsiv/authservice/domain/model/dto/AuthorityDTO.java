package com.okravtsiv.authservice.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class AuthorityDTO {

    private Long id;

    private String authority;

    public AuthorityDTO(String authority) {
        this.authority = authority;
    }
}
