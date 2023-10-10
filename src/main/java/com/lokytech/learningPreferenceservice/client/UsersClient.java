package com.lokytech.learningPreferenceservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "users-service")
public interface UsersClient {
    
}
