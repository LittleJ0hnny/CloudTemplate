package com.okravtsiv.authservice.domain.model;

public enum Authorities {
    ADMIN("ADMIN"),
    USER("USER");

    private String value;

    Authorities(String authority) {
        this.value = authority;
    }

    public String getValue() {
        return value;
    }
}
