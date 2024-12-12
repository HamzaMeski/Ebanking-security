package com.ebanking.backend.components.user.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.entities.User;
import com.ebanking.backend.components.user.dto.request.CreateUserDTO;
import com.ebanking.backend.components.user.dto.request.UpdateUserDTO;
import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<User, Long,
    CreateUserDTO, UpdateUserDTO, UserResponseDTO> {

    
    User toEntity(CreateUserDTO createDTO);

    
    void updateEntity(UpdateUserDTO updateDTO, @MappingTarget User entity);

    UserResponseDTO toResponseDTO(User entity);
}
