package com.subrutin.lingkar.catalog.service.impl;

import com.subrutin.lingkar.catalog.domain.User;
import com.subrutin.lingkar.catalog.dto.LoginRequestDTO;
import com.subrutin.lingkar.catalog.dto.LoginResponseDTO;
import com.subrutin.lingkar.catalog.service.AuthService;
import com.subrutin.lingkar.catalog.service.UserService;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    private final UserService userService;


    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userService.authenticateUser(dto.username(), dto.password());
        String token = Jwt.issuer("https://nostratech.com")
                .subject(user.getUsername()).groups(user.getRole().toString())
                .expiresAt(System.currentTimeMillis() + 3600).sign();

        return new LoginResponseDTO(token);
    }

}
