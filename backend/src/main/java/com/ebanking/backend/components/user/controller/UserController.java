package com.ebanking.backend.components.user.controller;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import com.ebanking.backend.components.user.service.UserService;
import com.ebanking.backend.entities.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
