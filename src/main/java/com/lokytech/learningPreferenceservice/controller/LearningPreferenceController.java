package com.lokytech.learningPreferenceservice.controller;


import com.lokytech.learningPreferenceservice.dto.LearningPreferenceDTO;
import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.exception.UserNotFoundException;
import com.lokytech.learningPreferenceservice.service.LearningPreferenceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LearningPreferenceController {

    @Autowired
    LearningPreferenceService preferenceService;

    @PostMapping("/preferences/{userId}")
    public ResponseEntity<LearningPreference> createLearningPreference(@PathVariable Long userId, @Valid @RequestBody LearningPreference learningPreference){
        LearningPreference preference = preferenceService.savePreference(learningPreference, userId);
        return new ResponseEntity<>(preference, HttpStatus.CREATED);
    }

    @GetMapping("/preferences/{userId}")
    public ResponseEntity<?> getUserLearningPreferenceById(@PathVariable Long userId){
        try{
            LearningPreferenceDTO learningPreferenceDTO = preferenceService.findPreferenceById(userId);
            return new ResponseEntity<>(learningPreferenceDTO, HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
