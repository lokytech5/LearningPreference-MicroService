package com.lokytech.learningPreferenceservice.dto;

import com.lokytech.learningPreferenceservice.enums.AreaType;


public class AreaToImproveDTO {
    private Long areaId;
    private AreaType areaType;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }
}
