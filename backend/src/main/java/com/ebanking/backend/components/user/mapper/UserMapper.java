package com.ebanking.backend.components.user.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.components.role.repository.RoleRepository;
import com.ebanking.backend.components.user.dto.request.UpdateUserInfoDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserRoleDTO;
import com.ebanking.backend.config.exception.ValidationException;
import com.ebanking.backend.entities.Role;
import com.ebanking.backend.entities.User;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements EntityMapper<User, Long, CreateUserDTO, UpdateUserInfoDTO, UserResponseDTO> {

    @Autowired
    protected RoleRepository roleRepository;
    
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "role", expression = "java(getRoleFromName(createDTO.getRole()))")
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(createDTO.getPassword()))")
    public abstract User toEntity(CreateUserDTO createDTO);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", expression = "java(updateDTO.getPassword() != null ? passwordEncoder.encode(updateDTO.getPassword()) : entity.getPassword())")
    public abstract void updateEntity(UpdateUserInfoDTO updateDTO, @MappingTarget User entity);

    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", expression = "java(getRoleFromName(updateDTO.getRole()))")
    public abstract void updateEntityRole(UpdateUserRoleDTO updateDTO, @MappingTarget User entity);


    @Mapping(target = "role", expression = "java(entity.getRole().getName())")
    public abstract UserResponseDTO toResponseDTO(User entity);

    protected Role getRoleFromName(String roleName) {
        if (roleName == null) return null;
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new ValidationException("Role not found: " + roleName));
    }
}