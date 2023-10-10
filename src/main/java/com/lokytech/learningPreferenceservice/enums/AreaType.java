package com.lokytech.learningPreferenceservice.enums;

public enum AreaType {
    MATH_SKILLS("Math Skills"),
    COMMUNICATION("Communication"),
    // ... other areas ...
    ;

    private final String description;

    AreaType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
