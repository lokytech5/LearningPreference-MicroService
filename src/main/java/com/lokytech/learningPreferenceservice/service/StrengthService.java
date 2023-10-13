package com.lokytech.learningPreferenceservice.service;

import com.lokytech.learningPreferenceservice.client.UsersClient;
import com.lokytech.learningPreferenceservice.dto.StrengthDTO;
import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.entity.Strength;
import com.lokytech.learningPreferenceservice.exception.UserNotFoundException;
import com.lokytech.learningPreferenceservice.repository.StrengthRepository;
import com.lokytech.learningPreferenceservice.validator.UserExistenceValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrengthService {

    @Autowired
    StrengthRepository strengthRepository;

    @Autowired
    private UsersClient usersClient;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserExistenceValidator userExistenceValidator;

    public Strength saveStrength(Strength strength, Long userId) {
        UsersDTO user = userExistenceValidator.validateUserExists(userId);
        strength.setUserId(user.getId());
        return strengthRepository.save(strength);
    }

    public StrengthDTO findStrengthById(Long userId){
        UsersDTO user = usersClient.getUserById(userId);
        Strength strength = strengthRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Not Found with ID " + userId));
        return modelMapper.map(strength, StrengthDTO.class);
    }
}
