package com.pulsetrade.user_service.domain.repository;

import com.pulsetrade.user_service.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
    Optional<User> findById(UUID id);
}
