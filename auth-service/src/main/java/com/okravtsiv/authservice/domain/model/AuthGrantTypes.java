package com.okravtsiv.authservice.domain.model;

public enum AuthGrantTypes {
    password("password"),
    refresh_token("refresh_token");

    private String value;

    AuthGrantTypes(String authGrantType) {
        this.value = authGrantType;
    }

    public String getValue() {
        return value;
    }
}
