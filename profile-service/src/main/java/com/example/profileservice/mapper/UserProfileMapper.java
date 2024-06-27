package com.example.profileservice.mapper;

import org.mapstruct.Mapper;

import com.example.profileservice.dto.request.UserProfileCreationRequest;
import com.example.profileservice.dto.response.UserProfileResponse;
import com.example.profileservice.model.UserProfile;

@Mapper
public interface UserProfileMapper {

    UserProfile toUserProfile(UserProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
