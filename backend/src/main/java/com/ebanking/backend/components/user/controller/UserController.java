package com.ebanking.backend.components.user.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import com.ebanking.backend.components.user.service.UserService;
import com.ebanking.backend.entities.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController extends Controller<User, Long, CreateUserDTO, UpdateUserDTO, UserResponseDTO> {
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


    @PutMapping("/{id}/updateRole")
    public ResponseEntity<UserResponseDTO> updateRole(@PathVariable Long id, @Valid @RequestBody UpdateUserDTO request) {
        super.update(id, request);
        return ResponseEntity.ok().build();
    }
}