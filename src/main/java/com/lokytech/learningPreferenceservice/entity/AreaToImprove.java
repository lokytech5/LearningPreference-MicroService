package com.lokytech.learningPreferenceservice.entity;
import com.lokytech.learningPreferenceservice.enums.AreaType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class AreaToImprove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "AreaType cannot be null")
    private AreaType areaType;

    public AreaToImprove() {
    }

    public AreaToImprove(java.lang.Long areaId, Long userId, AreaType areaType) {
        this.areaId = areaId;
        this.userId = userId;
        this.areaType = areaType;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }
}
