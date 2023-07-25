package com.mxo.DTO;

import com.mxo.Entity.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

public class UserDTO {

    @Data
    public static class UserCreateRequest {

        @NotNull(message = "The user name should not be null")
        @NotEmpty(message = "The user name should not be empty")
        private String name;
        @NotNull(message = "The user email should not be null")
        @Email(message = "Invalid email")
        private String email;
        private String phoneNumber;
        private String password;
        @Enumerated(EnumType.STRING)
        private Role role;
    }   

    @Data
    @AllArgsConstructor
    public static class UserCreateResponse {

        private String token;
    }   

    @Data
    public static class UserInfo {

        private Long userId;
        private String name;
        private String email;
        private String phoneNumber;
        private String role;
    }   

    @Data
    public static class UserUpdateRequest {
       
        private Long userId;
        private String name;
        private String phoneNumber;
        private String password;
        private String email;
    }
}
