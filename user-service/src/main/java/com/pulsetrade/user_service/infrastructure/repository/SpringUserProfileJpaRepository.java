package com.pulsetrade.user_service.infrastructure.repository;

import com.pulsetrade.user_service.infrastructure.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringUserProfileJpaRepository extends JpaRepository<UserProfileEntity, UUID> {
}
