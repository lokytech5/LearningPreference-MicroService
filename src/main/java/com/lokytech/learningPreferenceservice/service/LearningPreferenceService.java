package com.lokytech.learningPreferenceservice.service;
import com.lokytech.learningPreferenceservice.client.UsersClient;
import com.lokytech.learningPreferenceservice.dto.LearningPreferenceDTO;
import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.exception.ExternalServiceException;
import com.lokytech.learningPreferenceservice.exception.UserNotFoundException;
import com.lokytech.learningPreferenceservice.repository.LearningPreferenceRepository;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningPreferenceService {

    @Autowired
    LearningPreferenceRepository preferenceRepository;

    @Autowired
    private UsersClient usersClient;

    @Autowired
    ModelMapper modelMapper;

    public LearningPreference savePreference(LearningPreference learningPreference, Long userId) {
        try {
            UsersDTO user = usersClient.getUserById(userId);
            if (user == null || user.getId() == null) {
                throw new UserNotFoundException("User with ID " + userId + " not found in user-service.");
            }
            learningPreference.setUserId(user.getId());
            return preferenceRepository.save(learningPreference);
        } catch (FeignException e) {
            // Handle Feign-specific exceptions
            if (e.status() == 404) {
                throw new UserNotFoundException("User with ID " + userId + " not found in user-service.");
            } else {
                throw new ExternalServiceException("Error occurred when calling user-service: " + e.contentUTF8(), e);
            }
        }
    }

    public LearningPreferenceDTO findPreferenceById(Long userId){
        try {
            UsersDTO user = usersClient.getUserById(userId);
            if (user == null || user.getId() == null) {
                throw new UserNotFoundException("User with ID " + userId + " not found in user-service.");
            }
            LearningPreference learningPreference = preferenceRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User Not Found with ID " + userId));
            return modelMapper.map(learningPreference, LearningPreferenceDTO.class);
        } catch (FeignException e) {
            if (e.status() == 404) {
                throw new UserNotFoundException("User with ID " + userId + " not found in user-service.");
            } else {
                throw new ExternalServiceException("Error occurred when calling user-service: " + e.contentUTF8(), e);
            }
        }

    }
}
