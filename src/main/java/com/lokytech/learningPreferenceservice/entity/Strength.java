package com.lokytech.learningPreferenceservice.entity;

import com.lokytech.learningPreferenceservice.enums.StrengthType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Strength {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long strengthId;
    private Long userId;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Strength type cannot be null")
    private StrengthType strengthType;

    public Strength() {
    }

    public Strength(Long strengthId, Long userId, StrengthType strengthType) {
        this.strengthId = strengthId;
        this.userId = userId;
        this.strengthType = strengthType;
    }

    public Long getStrengthId() {
        return strengthId;
    }

    public void setStrengthId(Long strengthId) {
        this.strengthId = strengthId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public StrengthType getStrengthType() {
        return strengthType;
    }

    public void setStrengthType(StrengthType strengthType) {
        this.strengthType = strengthType;
    }
}
