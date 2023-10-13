package com.lokytech.learningPreferenceservice.dto;

import com.lokytech.learningPreferenceservice.enums.PreferenceType;

public class LearningPreferenceDTO {
    private Long preferenceId;

    private PreferenceType preferenceType;

    public Long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Long preferenceId) {
        this.preferenceId = preferenceId;
    }

    public PreferenceType getPreferenceType() {
        return preferenceType;
    }

    public void setPreferenceType(PreferenceType preferenceType) {
        this.preferenceType = preferenceType;
    }
}
