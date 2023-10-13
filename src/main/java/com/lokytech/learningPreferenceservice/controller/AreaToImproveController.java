package com.lokytech.learningPreferenceservice.controller;

import com.lokytech.learningPreferenceservice.dto.AreaToImproveDTO;
import com.lokytech.learningPreferenceservice.dto.StrengthDTO;
import com.lokytech.learningPreferenceservice.entity.AreaToImprove;
import com.lokytech.learningPreferenceservice.entity.Strength;
import com.lokytech.learningPreferenceservice.exception.UserNotFoundException;
import com.lokytech.learningPreferenceservice.service.AreaToImproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AreaToImproveController {
    @Autowired
    AreaToImproveService areaToImproveService;

    @PostMapping("/areas/{userId}")
    public ResponseEntity<AreaToImprove> createAreaToImprove(@PathVariable Long userId, @RequestBody AreaToImprove areaToImprove){
        AreaToImprove savedAreaToImprove = areaToImproveService.saveAreaToImprove(areaToImprove, userId);
        return new ResponseEntity<>(savedAreaToImprove, HttpStatus.CREATED);
    }

    @GetMapping("/areas/{userId}")
    public ResponseEntity<?> getUserAreaToImproveById(@PathVariable Long userId){
        try{
            AreaToImproveDTO areaToImproveDTO = areaToImproveService.findAreaToImproveById(userId);
            return new ResponseEntity<>(areaToImproveDTO, HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
