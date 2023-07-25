package com.mxo.Authentication;

import com.mxo.DTO.UserDTO.UserInfo;

public record AuthenticationResponse(
    String token, 
    UserInfo userInfo) {
}