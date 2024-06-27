package com.example.profileservice.controller;

import org.springframework.web.bind.annotation.*;

import com.example.profileservice.dto.request.UserProfileCreationRequest;
import com.example.profileservice.dto.response.ApiResponse;
import com.example.profileservice.dto.response.UserProfileResponse;
import com.example.profileservice.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {

    UserProfileService userProfileService;

    @PostMapping("/user/{userId}")
    public UserProfileResponse createProfile(@PathVariable String userId,
                                                          @RequestBody UserProfileCreationRequest request) {
        return userProfileService.createUserProfile(userId, request);
    }

    @GetMapping
    public ApiResponse<List<UserProfileResponse>> getAllProfiles() {
        return new ApiResponse<>(userProfileService.getAllUserProfiles());
    }
}
