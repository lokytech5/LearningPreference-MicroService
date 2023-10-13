package com.lokytech.learningPreferenceservice.controller;

import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.entity.Strength;
import com.lokytech.learningPreferenceservice.service.StrengthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StrengthController {

    @Autowired
    StrengthService strengthService;

    @PostMapping("/strength/{userId}")
    public ResponseEntity<Strength> createStrength(@PathVariable Long userId, @RequestBody Strength strength){
        Strength savedStrength = strengthService.saveStrength(strength, userId);
        return new ResponseEntity<>(savedStrength, HttpStatus.CREATED);
    }
}
