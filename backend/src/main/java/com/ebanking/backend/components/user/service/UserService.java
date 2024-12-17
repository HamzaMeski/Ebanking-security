package com.ebanking.backend.components.user.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserInfoDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserRoleDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import com.ebanking.backend.components.user.mapper.UserMapper;
import com.ebanking.backend.components.user.repository.UserRepository;
import com.ebanking.backend.config.exception.ValidationException;
import com.ebanking.backend.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class UserService extends EntityServiceImpl<User, Long, CreateUserDTO, UpdateUserInfoDTO, UserResponseDTO> {
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

    public void updateRole(Long id, UpdateUserRoleDTO updateUserRoleDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ValidationException("user doesn't exist with id: " + id));

        userMapper.updateEntityRole(updateUserRoleDTO, user);
        userRepository.save(user);
    }
}
