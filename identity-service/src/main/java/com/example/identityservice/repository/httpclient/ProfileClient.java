package com.example.identityservice.repository.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.identityservice.dto.request.UserProfileCreationRequest;
import com.example.identityservice.dto.response.UserProfileResponse;

@FeignClient(name = "profile-service", url = "${app.services.profile}")
public interface ProfileClient {

    @PostMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse createUserProfile(
            @PathVariable("userId") String userId, @RequestBody UserProfileCreationRequest request);
}
