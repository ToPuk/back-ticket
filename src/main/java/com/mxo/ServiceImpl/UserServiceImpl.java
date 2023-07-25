package com.mxo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mxo.DTO.UserDTO.UserCreateRequest;
import com.mxo.DTO.UserDTO.UserInfo;
import com.mxo.DTO.UserDTO.UserUpdateRequest;
import com.mxo.DTOMapper.UserDTOMapper;
import com.mxo.Entity.User;
import com.mxo.Exception.DuplicateResourceException;
import com.mxo.Exception.RequestValidationException;
import com.mxo.Exception.ResourceNotFoundException;
import com.mxo.Repository.UserRepository;
import com.mxo.Service.UserService;
import com.mxo.Validator.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectValidator<UserCreateRequest> objectValidator;

    @Override
    public void createUser(UserCreateRequest request) {
        objectValidator.validate(request);
        if (userRepository.existsUserByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already taken");
        }
        User user = UserDTOMapper.INSTANCE.createToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<UserInfo> getUsers() {
        return userRepository
            .findAll()
            .stream()
            .map(UserDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList()
        );
    }

    @Override
    public UserInfo getUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User with id [%s] not found".formatted(id)));
        return UserDTOMapper.INSTANCE.entityToResponse(user);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User with id [%s] not found".formatted(id));
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("Deletion success");
    }

    @Override
    public ResponseEntity<String> updateUser(UserUpdateRequest request) {
        if (request.getUserId() == null ){
            throw new RequestValidationException("The given id must not be null"); 
        }
        User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new ResourceNotFoundException("User with id [%s] not found".formatted(request.getUserId())));

        boolean changes = false;

        if (request.getName() != null && !request.getName().equals(user.getName())) {
            user.setName(request.getName());
            changes = true;
        }

        if (request.getEmail() != null && !request.getEmail().equals(user.getEmail())) {
            if (userRepository.existsUserByEmail(request.getEmail())) {
                throw new DuplicateResourceException("Email already taken");
            }
            user.setEmail(request.getEmail());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("No data changes found");
        }
        userRepository.save(user);
        return ResponseEntity.ok().body("Update success");
    }
}
