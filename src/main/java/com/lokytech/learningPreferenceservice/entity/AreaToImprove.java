package com.lokytech.learningPreferenceservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AreaToImprove {
    @Id
    private Long areaId;

//    private Users users;

    private String areaType;
}
