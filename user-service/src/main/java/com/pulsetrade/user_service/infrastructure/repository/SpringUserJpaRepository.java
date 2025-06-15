package com.pulsetrade.user_service.infrastructure.repository;

import com.pulsetrade.user_service.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringUserJpaRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
