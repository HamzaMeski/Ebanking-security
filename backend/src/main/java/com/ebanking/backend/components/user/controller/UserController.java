package com.ebanking.backend.components.user.controller;

import com.ebanking.backend.components.user.dto.request.UpdateUserInfoDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserRoleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import com.ebanking.backend.components.user.service.UserService;
import com.ebanking.backend.entities.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController extends Controller<User, Long, CreateUserDTO, UpdateUserInfoDTO, UserResponseDTO> {
    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return super.create(createUserDTO);
    }

    @Override
    public ResponseEntity<Page<UserResponseDTO>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody UpdateUserInfoDTO request) {
        super.update(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/updateRole")
    public ResponseEntity<UserResponseDTO> updateRole(@PathVariable Long id, @Valid @RequestBody UpdateUserRoleDTO request) {
        userService.updateRole(id, request);
        return ResponseEntity.ok().build();
    }
}