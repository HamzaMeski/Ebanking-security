package com.ebanking.backend.components.role.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.entities.Role;
import com.ebanking.backend.components.role.dto.request.CreateRoleDTO;
import com.ebanking.backend.components.role.dto.request.UpdateRoleDTO;
import com.ebanking.backend.components.role.dto.response.RoleResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<Role, Long,
    CreateRoleDTO, UpdateRoleDTO, RoleResponseDTO> {

    
    Role toEntity(CreateRoleDTO createDTO);

    
    void updateEntity(UpdateRoleDTO updateDTO, @MappingTarget Role entity);

    RoleResponseDTO toResponseDTO(Role entity);
}
