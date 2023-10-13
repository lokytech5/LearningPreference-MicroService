package com.lokytech.learningPreferenceservice.service;
import com.lokytech.learningPreferenceservice.client.UsersClient;
import com.lokytech.learningPreferenceservice.dto.LearningPreferenceDTO;
import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.entity.LearningPreference;
import com.lokytech.learningPreferenceservice.exception.ExternalServiceException;
import com.lokytech.learningPreferenceservice.exception.UserNotFoundException;
import com.lokytech.learningPreferenceservice.repository.LearningPreferenceRepository;
import com.lokytech.learningPreferenceservice.validator.UserExistenceValidator;
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

    @Autowired
    private UserExistenceValidator userExistenceValidator;

    public LearningPreference savePreference(LearningPreference learningPreference, Long userId) {
            UsersDTO user = userExistenceValidator.validateUserExists(userId);
            learningPreference.setUserId(user.getId());
            return preferenceRepository.save(learningPreference);
    }
    public LearningPreferenceDTO findPreferenceById(Long userId){
            UsersDTO user = usersClient.getUserById(userId);
            LearningPreference learningPreference = preferenceRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User Not Found with ID " + userId));
            return modelMapper.map(learningPreference, LearningPreferenceDTO.class);
    }
}
