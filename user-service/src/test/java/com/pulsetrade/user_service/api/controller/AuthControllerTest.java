package com.pulsetrade.user_service.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pulsetrade.user_service.api.dto.AuthResponse;
import com.pulsetrade.user_service.api.dto.LoginRequest;
import com.pulsetrade.user_service.api.dto.RegisterRequest;
import com.pulsetrade.user_service.application.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    //@Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegister() throws Exception{
        RegisterRequest request = new RegisterRequest();
        request.setEmail("abc@gmail.com");
        request.setPassword("pass123");
        request.setFirstName("John");
        request.setLastName("Doe");

        AuthResponse response = new AuthResponse("dummy-token", "USER");
        Mockito.when(authService.register(any())).thenReturn(response);

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("dummy-token"))
                .andExpect(jsonPath("$.role").value("USER"));
    }

    @Test
    void testLogin() throws Exception {
        LoginRequest request = new LoginRequest();
        request.setEmail("test@example.com");
        request.setPassword("secret123");

        AuthResponse response = new AuthResponse("dummy-token", "USER");
        Mockito.when(authService.login(any())).thenReturn(response);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("dummy-token"))
                .andExpect(jsonPath("$.role").value("USER"));
    }

}
