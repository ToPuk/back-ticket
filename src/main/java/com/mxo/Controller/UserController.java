package com.mxo.Controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mxo.DTO.UserDTO;
import com.mxo.DTO.UserDTO.UserCreateResponse;
import com.mxo.Jwt.JwtService;
import com.mxo.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO.UserCreateRequest request) {
        userService.createUser(request);
        String jwtToken = jwtService.generateToken(request.getEmail());
        return ResponseEntity.ok()
            .header(HttpHeaders.AUTHORIZATION, jwtToken)
            .body(new UserCreateResponse(jwtToken));
    }

    @GetMapping
    public List<UserDTO.UserInfo> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{userId}")
    public UserDTO.UserInfo getUser(@PathVariable("userId") Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "userId") Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserDTO.UserUpdateRequest request) {
        return userService.updateUser(request);
    }
}
