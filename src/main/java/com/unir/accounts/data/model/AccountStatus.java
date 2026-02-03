package com.unir.accounts.data.model;

import com.fasterxml.jackson.annotation.JsonValue;


public enum AccountStatus {

    ACTIVE("Activo"),
    INACTIVE("Inactivo");

    private final String label;

    AccountStatus(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    public static AccountStatus fromValue(String value) {
        for (AccountStatus type : values()) {
            if (type.label.equalsIgnoreCase(value)
                    || type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Estado invalido: " + value);
    }
}
