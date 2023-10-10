package com.lokytech.learningPreferenceservice.entity;

import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AreaToImprove {
    @Id
    private Long areaId;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName="userID", insertable=false, updatable=false)
    private UsersDTO usersDTO;

    private String areaType;

    public AreaToImprove() {
    }

    public AreaToImprove(Long areaId, UsersDTO usersDTO, String areaType) {
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

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }
}
