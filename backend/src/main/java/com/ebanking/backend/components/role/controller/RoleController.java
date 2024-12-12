package com.ebanking.backend.components.role.controller;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.role.dto.request.CreateRoleDTO;
import com.ebanking.backend.components.role.dto.request.UpdateRoleDTO;
import com.ebanking.backend.components.role.dto.response.RoleResponseDTO;
import com.ebanking.backend.components.role.service.RoleService;
import com.ebanking.backend.entities.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController extends Controller<Role, Long, CreateRoleDTO, UpdateRoleDTO, RoleResponseDTO> {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        super(roleService);
        this.roleService = roleService;
    }
}
