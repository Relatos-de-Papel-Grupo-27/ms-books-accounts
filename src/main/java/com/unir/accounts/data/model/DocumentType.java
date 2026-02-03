package com.unir.accounts.data.model;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {

    CEDULA_CIUDADANIA("Cedula Ciudadanía"),
    PASAPORTE("Pasaporte");

    private final String label;

    DocumentType(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    public static DocumentType fromValue(String value) {
        for (DocumentType type : values()) {
            if (type.label.equalsIgnoreCase(value)
                    || type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo documento invalido: " + value);
    }
}
