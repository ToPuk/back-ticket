package com.mxo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mxo.DTO.UserDTO.UserCreateRequest;
import com.mxo.DTO.UserDTO.UserInfo;
import com.mxo.DTO.UserDTO.UserUpdateRequest;

public interface UserService {
    
    public void createUser (UserCreateRequest request);
    public List<UserInfo> getUsers();
    public UserInfo getUser(Long id);
    public ResponseEntity<String> deleteUser(Long id);
    public ResponseEntity<String> updateUser(UserUpdateRequest request);
}
