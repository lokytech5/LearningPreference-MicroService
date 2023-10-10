package com.lokytech.learningPreferenceservice.entity;

import com.lokytech.learningPreferenceservice.dto.Users;
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
    private Users users;

    private String areaType;
}
