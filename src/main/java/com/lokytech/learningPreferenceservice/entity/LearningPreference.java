package com.lokytech.learningPreferenceservice.entity;

import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.enums.PreferenceType;
import jakarta.persistence.*;

@Entity
public class LearningPreference {
    @Id
    private Long preferenceId;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName="userID", insertable=false, updatable=false)
    private UsersDTO usersDTO;

    @Enumerated(EnumType.STRING)
    private PreferenceType preferenceType;

    public LearningPreference() {
    }

    public LearningPreference(Long preferenceId, UsersDTO usersDTO, PreferenceType preferenceType) {
        this.preferenceId = preferenceId;
        this.usersDTO = usersDTO;
        this.preferenceType = preferenceType;
    }

    public Long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Long preferenceId) {
        this.preferenceId = preferenceId;
    }

    public UsersDTO getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    public PreferenceType getPreferenceType() {
        return preferenceType;
    }

    public void setPreferenceType(PreferenceType preferenceType) {
        this.preferenceType = preferenceType;
    }
}
