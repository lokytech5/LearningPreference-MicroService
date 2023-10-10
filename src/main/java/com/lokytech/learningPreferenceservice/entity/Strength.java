package com.lokytech.learningPreferenceservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Strength {
    @Id
    private Long strengthId;

    private Long userId;

    private String strengthType;
}
