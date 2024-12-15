package com.ebanking.backend.components.role.repository;

import com.ebanking.backend.EntityComponentsProvider.repository.EntityRepository;
import com.ebanking.backend.entities.Role;

import java.util.Optional;

public interface RoleRepository extends EntityRepository<Role, Long> {
     Optional<Role> findByName(String name);
}
