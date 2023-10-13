package com.lokytech.learningPreferenceservice.dto;

import com.lokytech.learningPreferenceservice.enums.StrengthType;

public class StrengthDTO {
    private Long strengthId;

    private StrengthType strengthType;

    public Long getStrengthId() {
        return strengthId;
    }

    public void setStrengthId(Long strengthId) {
        this.strengthId = strengthId;
    }

    public StrengthType getStrengthType() {
        return strengthType;
    }

    public void setStrengthType(StrengthType strengthType) {
        this.strengthType = strengthType;
    }
}
