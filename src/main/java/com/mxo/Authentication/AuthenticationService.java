package com.mxo.Authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mxo.DTO.UserDTO.UserInfo;
import com.mxo.DTOMapper.UserDTOMapper;
import com.mxo.Entity.User;
import com.mxo.Jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
            )
        );
        User userPrincipal = (User) authentication.getPrincipal();
        UserInfo userInfo = UserDTOMapper.INSTANCE.entityToResponse(userPrincipal);
        String token = jwtService.generateToken(userPrincipal);
        return new AuthenticationResponse(token, userInfo);
    }
}
