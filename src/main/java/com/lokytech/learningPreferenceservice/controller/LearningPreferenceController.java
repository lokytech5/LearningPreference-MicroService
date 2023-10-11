package com.lokytech.learningPreferenceservice.controller;


import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.service.LearningPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LearningPreferenceController {

    @Autowired
    LearningPreferenceService preferenceService;

    @PostMapping("/preferences")
    public ResponseEntity<LearningPreference> createLearningPreference(@RequestBody LearningPreference learningPreference){
        LearningPreference preference = preferenceService.savePreference(learningPreference);
        return new ResponseEntity<>(preference, HttpStatus.CREATED);
    }
}
