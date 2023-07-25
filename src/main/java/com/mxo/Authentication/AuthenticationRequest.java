package com.mxo.Authentication;

public record AuthenticationRequest(
    String email,
    String password
) {
}
