package com.lokytech.learningPreferenceservice.service;
import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.repository.LearningPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningPreferenceService {

    @Autowired
    LearningPreferenceRepository preferenceRepository;

    public LearningPreference savePreference(LearningPreference learningPreference){
        return preferenceRepository.save(learningPreference);
    }
}
