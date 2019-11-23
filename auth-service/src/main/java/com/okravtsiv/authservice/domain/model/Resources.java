package com.okravtsiv.authservice.domain.model;

public enum Resources {
    GATEWAY_SERVICE("gateway");

    private String value;

    Resources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
