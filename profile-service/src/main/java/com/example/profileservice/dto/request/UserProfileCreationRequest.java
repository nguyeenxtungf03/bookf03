package com.example.profileservice.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileCreationRequest {
    String firstName;
    String lastName;
    String email;
    String phone;
    @JsonFormat(pattern = "dd-MM-yyyy")
    Date birthDate;
}
