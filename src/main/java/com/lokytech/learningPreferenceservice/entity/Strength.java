package com.lokytech.learningPreferenceservice.entity;

import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.enums.StrengthType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Strength {
    @Id
    private Long strengthId;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName="userID", insertable=false, updatable=false)
    private UsersDTO usersDTO;

    private StrengthType strengthType;

    public Strength() {
    }

    public Strength(Long strengthId, UsersDTO usersDTO, StrengthType strengthType) {
        this.strengthId = strengthId;
        this.usersDTO = usersDTO;
        this.strengthType = strengthType;
    }

    public Long getStrengthId() {
        return strengthId;
    }

    public void setStrengthId(Long strengthId) {
        this.strengthId = strengthId;
    }

    public UsersDTO getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    public StrengthType getStrengthType() {
        return strengthType;
    }

    public void setStrengthType(StrengthType strengthType) {
        this.strengthType = strengthType;
    }
}
