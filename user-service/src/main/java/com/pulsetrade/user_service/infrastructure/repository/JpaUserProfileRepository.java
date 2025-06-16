package com.pulsetrade.user_service.infrastructure.repository;

import com.pulsetrade.user_service.domain.model.UserProfile;
import com.pulsetrade.user_service.domain.repository.IUserProfileRepository;
import com.pulsetrade.user_service.infrastructure.entity.UserProfileEntity;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserProfileRepository implements IUserProfileRepository {

    private final SpringUserProfileJpaRepository springRepo;

    public JpaUserProfileRepository(SpringUserProfileJpaRepository springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public Optional<UserProfile> findByUserId(UUID userId) {
        return springRepo.findById(userId).map(this::toDomain);
    }

    @Override
    public void save(UserProfile profile) {
        springRepo.save(toEntity(profile));
    }

    private UserProfile toDomain(UserProfileEntity entity) {
        return new UserProfile(
                entity.getUserId(),
                entity.getDisplayName(),
                entity.getPhoneNumber(),
                entity.getBio(),
                entity.getLocation(),
                entity.getProfileImageUrl()
        );
    }

    private UserProfileEntity toEntity(UserProfile profile) {
        UserProfileEntity entity = new UserProfileEntity();
        entity.setUserId(profile.getUserId());
        entity.setDisplayName(profile.getDisplayName());
        entity.setBio(profile.getBio());
        entity.setLocation(profile.getLocation());
        entity.setPhoneNumber(profile.getPhoneNumber());
        entity.setProfileImageUrl(profile.getProfileImageUrl());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return entity;
    }

}
