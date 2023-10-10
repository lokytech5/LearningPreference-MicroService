package com.lokytech.learningPreferenceservice.service;

import com.lokytech.learningPreferenceservice.repository.LearningPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningPreferenceService {

    @Autowired
    private LearningPreference learningPreference;

    public LearningPreference saveUserPreference(LearningPreference preference){
      return learningPreference.save(preference);
    }
}
