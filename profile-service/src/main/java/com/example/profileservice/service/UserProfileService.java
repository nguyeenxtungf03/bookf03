package com.example.profileservice.service;

import com.example.profileservice.model.UserProfile;
import org.springframework.stereotype.Service;

import com.example.profileservice.dto.request.UserProfileCreationRequest;
import com.example.profileservice.dto.response.UserProfileResponse;
import com.example.profileservice.mapper.UserProfileMapper;
import com.example.profileservice.repository.UserProfileRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileService {

    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createUserProfile(String userId, UserProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile.setUserId(userId);
        return userProfileMapper.toUserProfileResponse(userProfileRepository.save(userProfile));
    }

    public List<UserProfileResponse> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        return userProfiles.stream().map(userProfileMapper::toUserProfileResponse).collect(Collectors.toList());
    }
}
