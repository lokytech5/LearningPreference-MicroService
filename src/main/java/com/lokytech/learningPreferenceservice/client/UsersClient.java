package com.lokytech.learningPreferenceservice.client;

import com.lokytech.learningPreferenceservice.dto.UsersDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="user-service")
public interface UsersClient {

    @GetMapping("/api/users/{id}")
    UsersDTO getUserById(@PathVariable("id") Long id);
}
