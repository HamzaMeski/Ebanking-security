package com.ebanking.backend.components.user.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.components.role.repository.RoleRepository;
import com.ebanking.backend.entities.Role;
import com.ebanking.backend.entities.User;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public abstract class UserMapper implements EntityMapper<User, Long, CreateUserDTO, UpdateUserDTO, UserResponseDTO> {

    @Autowired
    protected RoleRepository roleRepository;

    @Mapping(target = "role", expression = "java(getRoleFromName(createDTO.getRole()))")
    public abstract User toEntity(CreateUserDTO createDTO);

    @Mapping(target = "role", expression = "java(getRoleFromName(updateDTO.getRole()))")
    public abstract void updateEntity(UpdateUserDTO updateDTO, @MappingTarget User entity);

    @Mapping(target = "role", expression = "java(entity.getRole().getName())")
    public abstract UserResponseDTO toResponseDTO(User entity);

    protected Role getRoleFromName(String roleName) {
        if (roleName == null) return null;
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
    }
}