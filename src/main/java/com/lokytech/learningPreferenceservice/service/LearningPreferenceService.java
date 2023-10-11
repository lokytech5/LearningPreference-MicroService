package com.lokytech.learningPreferenceservice.service;
import com.lokytech.learningPreferenceservice.client.UsersClient;
import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.repository.LearningPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningPreferenceService {

    @Autowired
    LearningPreferenceRepository preferenceRepository;

    @Autowired
    private UsersClient usersClient;

    public LearningPreference savePreference(LearningPreference learningPreference, Long userId){
        UsersDTO user = usersClient.getUserById(userId);
        learningPreference.setUserId(user.getId());
        return preferenceRepository.save(learningPreference);
    }
}
