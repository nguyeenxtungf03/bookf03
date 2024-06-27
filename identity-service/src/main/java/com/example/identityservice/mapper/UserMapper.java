package com.example.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.identityservice.dto.request.UserCreationRequest;
import com.example.identityservice.dto.request.UserProfileCreationRequest;
import com.example.identityservice.dto.request.UserUpdateRequest;
import com.example.identityservice.dto.response.UserResponse;
import com.example.identityservice.model.User;

@Mapper
public interface UserMapper {

    UserResponse toUserResponse(User user);

    @Mapping(target = "password", source = "request", qualifiedByName = "userRequestToUser")
    User toUser(UserCreationRequest request);

    @Mapping(target = "password", source = "request", qualifiedByName = "userRequestToUser")
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    @Mapping(target = "phone", source = "phoneNumber")
    @Mapping(target = "birthDate", source = "dob")
    UserProfileCreationRequest toUserProfileCreationRequest(UserCreationRequest user);

    @Named("userRequestToUser")
    default String userRequestToUser(UserCreationRequest request) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(request.getPassword());
    }

    @Named("userRequestToUser")
    default String userRequestToUser(UserUpdateRequest request) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(request.getPassword());
    }

    private String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
