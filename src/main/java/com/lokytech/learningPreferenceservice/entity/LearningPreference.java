package com.lokytech.learningPreferenceservice.entity;

import com.lokytech.learningPreferenceservice.enums.PreferenceType;
import jakarta.persistence.*;

@Entity
public class LearningPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preferenceId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private PreferenceType preferenceType;

    public LearningPreference() {
    }

    public LearningPreference(Long preferenceId, Long userId, PreferenceType preferenceType) {
        this.preferenceId = preferenceId;
        this.userId = userId;
        this.preferenceType = preferenceType;
    }

    public Long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Long preferenceId) {
        this.preferenceId = preferenceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PreferenceType getPreferenceType() {
        return preferenceType;
    }

    public void setPreferenceType(PreferenceType preferenceType) {
        this.preferenceType = preferenceType;
    }
}
