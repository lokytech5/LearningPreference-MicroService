package com.lokytech.learningPreferenceservice.controller;


import com.lokytech.learningPreferenceservice.dto.StrengthDTO;
import com.lokytech.learningPreferenceservice.entity.Strength;
import com.lokytech.learningPreferenceservice.exception.UserNotFoundException;
import com.lokytech.learningPreferenceservice.service.StrengthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StrengthController {

    @Autowired
    StrengthService strengthService;

    @PostMapping("/strength/{userId}")
    public ResponseEntity<Strength> createStrength(@PathVariable Long userId, @Valid @RequestBody Strength strength){
        Strength savedStrength = strengthService.saveStrength(strength, userId);
        return new ResponseEntity<>(savedStrength, HttpStatus.CREATED);
    }

    @GetMapping("/strength/{userId}")
    public ResponseEntity<?> getUserStrengthById(@PathVariable Long userId){
        try{
            StrengthDTO strengthDTO = strengthService.findStrengthById(userId);
            return new ResponseEntity<>(strengthDTO, HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
