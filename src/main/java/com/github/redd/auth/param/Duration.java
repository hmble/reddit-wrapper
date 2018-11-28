package com.github.redd.auth.param;

public enum Duration {
    PERMANENT("permanent"),
    TEMPORARY("temporary");

    private final String value;

    Duration(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
