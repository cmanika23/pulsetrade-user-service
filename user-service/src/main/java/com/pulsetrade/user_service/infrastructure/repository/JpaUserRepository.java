package com.pulsetrade.user_service.infrastructure.repository;

import com.pulsetrade.user_service.domain.model.User;
import com.pulsetrade.user_service.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements IUserRepository {

    @Autowired
    private final SpringUserJpaRepository springRepo;

    @Override
    public Optional<User> findByEmail(String email) {
        return springRepo.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }
}
