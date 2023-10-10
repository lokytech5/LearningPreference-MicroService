package com.lokytech.learningPreferenceservice.entity;

import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.enums.AreaType;
import jakarta.persistence.*;

@Entity
public class AreaToImprove {
    @Id
    private Long areaId;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName="userID", insertable=false, updatable=false)
    private UsersDTO usersDTO;

    @Enumerated(EnumType.STRING)
    private AreaType areaType;

    public AreaToImprove() {
    }

    public AreaToImprove(Long areaId, UsersDTO usersDTO, AreaType areaType) {
        this.areaId = areaId;
        this.usersDTO = usersDTO;
        this.areaType = areaType;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public UsersDTO getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }
}
