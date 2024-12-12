package com.ebanking.backend.components.user.repository;

import com.ebanking.backend.EntityComponentsProvider.repository.EntityRepository;
import com.ebanking.backend.entities.User;

import java.util.Optional;

public interface UserRepository extends EntityRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
