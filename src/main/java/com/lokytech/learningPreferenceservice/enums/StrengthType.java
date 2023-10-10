package com.lokytech.learningPreferenceservice.enums;

public enum StrengthType {

    PROBLEM_SOLVING("Problem Solving"),
    TEAMWORK("Teamwork"),
    // ... other strengths ...
    ;

    private final String description;

    StrengthType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
