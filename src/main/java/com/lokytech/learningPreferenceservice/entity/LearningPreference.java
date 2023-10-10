package com.lokytech.learningPreferenceservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LearningPreference {
    @Id
    private Long preferenceId;
    private Long userId;

    private String preferenceType;


}
