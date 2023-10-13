package com.lokytech.learningPreferenceservice.service;

import com.lokytech.learningPreferenceservice.client.UsersClient;
import com.lokytech.learningPreferenceservice.dto.AreaToImproveDTO;

import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import com.lokytech.learningPreferenceservice.entity.AreaToImprove;

import com.lokytech.learningPreferenceservice.exception.UserNotFoundException;
import com.lokytech.learningPreferenceservice.repository.AreaToImproveRepository;
import com.lokytech.learningPreferenceservice.validator.UserExistenceValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaToImproveService {
    @Autowired
    AreaToImproveRepository areaToImproveRepository;

    @Autowired
    private UsersClient usersClient;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserExistenceValidator userExistenceValidator;

    public AreaToImprove saveAreaToImprove(AreaToImprove areaToImprove, Long userId) {
        UsersDTO user = userExistenceValidator.validateUserExists(userId);
        areaToImprove.setUserId(user.getId());
        return areaToImproveRepository.save(areaToImprove);
    }

    public AreaToImproveDTO findAreaToImproveById(Long userId){
        UsersDTO user = usersClient.getUserById(userId);
        AreaToImprove areaToImprove = areaToImproveRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Not Found with ID " + userId));
        return modelMapper.map(areaToImprove, AreaToImproveDTO.class);
    }
}
