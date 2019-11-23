package com.okravtsiv.authservice.domain.model;

public enum Scopes {
    MYSCOPE("myscope");

    private String value;

    Scopes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
