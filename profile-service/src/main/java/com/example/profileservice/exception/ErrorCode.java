package com.example.profileservice.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    VALIDATION_FAILED("EPS00001", "Validation failed", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED("EPS00002", "Unauthenticated", HttpStatus.UNAUTHORIZED),
    GENERATE_TOKEN_FAILED("EPS00003", "Generate token failed", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_ALREADY_EXISTS("EPS00004", "Username already exists", HttpStatus.CONFLICT),
    UNAUTHORIZED("EPS00005", "Unauthorized", HttpStatus.FORBIDDEN),
    INVALID_KEY("EPS00006", "Uncategorized error", HttpStatus.BAD_REQUEST),
    ;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
