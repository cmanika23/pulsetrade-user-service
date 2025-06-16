package com.pulsetrade.user_service.domain.repository;

import com.pulsetrade.user_service.domain.model.UserProfile;

import java.util.Optional;
import java.util.UUID;

public interface IUserProfileRepository {
    Optional<UserProfile> findByUserId(UUID userId);
    void save(UserProfile profile);
}
