package com.lokytech.learningPreferenceservice.enums;

public enum PreferenceType {
    VISUAL_LEARNER("Visual Learner"),
    AUDITORY_LEARNER("Auditory Learner"),
    KINESTHETIC_LEARNER("Kinesthetic Learner");

    private final String description;

    PreferenceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
