package com.example.profileservice.dto.response;

import java.util.Date;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileResponse {
    String id;
    String userId;
    String firstName;
    String lastName;
    String email;
    String phone;
    Date birthDate;
}
