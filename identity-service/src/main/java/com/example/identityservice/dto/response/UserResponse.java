package com.example.identityservice.dto.response;

import java.util.Set;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;

    String username;

    String password;

    Set<RoleResponse> roleResponses;

    UserProfileResponse userProfileResponse;
}
