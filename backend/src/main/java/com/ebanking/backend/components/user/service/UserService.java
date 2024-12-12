package com.ebanking.backend.components.user.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import com.ebanking.backend.components.user.mapper.UserMapper;
import com.ebanking.backend.components.user.repository.UserRepository;
import com.ebanking.backend.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class UserService extends EntityServiceImpl<User, Long, CreateUserDTO, UpdateUserDTO, UserResponseDTO> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper,
            ApplicationContext applicationContext) {
        super(userRepository, userMapper, applicationContext);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
}
