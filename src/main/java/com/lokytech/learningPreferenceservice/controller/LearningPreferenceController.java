package com.lokytech.learningPreferenceservice.controller;


import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.service.LearningPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LearningPreferenceController {

    @Autowired
    LearningPreferenceService preferenceService;

    @PostMapping("/preferences/{userId}")
    public ResponseEntity<LearningPreference> createLearningPreference(@PathVariable Long userId, @RequestBody LearningPreference learningPreference){
        LearningPreference preference = preferenceService.savePreference(learningPreference, userId);
        return new ResponseEntity<>(preference, HttpStatus.CREATED);
    }
}
