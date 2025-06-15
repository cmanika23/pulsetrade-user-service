package com.pulsetrade.user_service.application.service;

import com.pulsetrade.user_service.api.dto.AuthResponse;
import com.pulsetrade.user_service.api.dto.LoginRequest;
import com.pulsetrade.user_service.api.dto.RegisterRequest;
import com.pulsetrade.user_service.domain.model.Role;
import com.pulsetrade.user_service.domain.model.User;
import com.pulsetrade.user_service.domain.repository.IUserRepository;
import com.pulsetrade.user_service.infrastructure.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public AuthResponse register(RegisterRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .id(UUID.randomUUID())
                .email(request.getEmail())
                .passwordHash((passwordEncoder.encode(request.getPassword())))
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName()!=null? request.getMiddleName() : " ")
                .lastName(request.getLastName())
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        System.out.println("User created: " + user.toString());
        userRepository.save(user);

        String token = jwtTokenProvider.generateToken(user);

        return new AuthResponse(token, user.getRole().name());
    }

    public AuthResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())){
            throw new RuntimeException("Invalid password");
        }

        String token = jwtTokenProvider.generateToken(user);
        return new AuthResponse(token, user.getRole().name());
    }


}
