package com.ebanking.backend.components.role.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.role.dto.request.CreateRoleDTO;
import com.ebanking.backend.components.role.dto.request.UpdateRoleDTO;
import com.ebanking.backend.components.role.dto.response.RoleResponseDTO;
import com.ebanking.backend.components.role.mapper.RoleMapper;
import com.ebanking.backend.components.role.repository.RoleRepository;
import com.ebanking.backend.entities.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class RoleService extends EntityServiceImpl<Role, Long, CreateRoleDTO, UpdateRoleDTO, RoleResponseDTO> {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(
            RoleRepository roleRepository,
            RoleMapper roleMapper,
            ApplicationContext applicationContext) {
        super(roleRepository, roleMapper, applicationContext);
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }
}
