package com.subrutin.lingkar.catalog.service.impl;

import com.subrutin.lingkar.catalog.domain.User;
import com.subrutin.lingkar.catalog.domain.enums.Role;
import com.subrutin.lingkar.catalog.dto.UserCreateRequestDTO;
import com.subrutin.lingkar.catalog.repository.UserRepository;
import com.subrutin.lingkar.catalog.service.UserService;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserCreateRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(BcryptUtil.bcryptHash(dto.password()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    @Override
    public User authenticateUser(String username, String clearPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("invalid user/password"));

        if (!BcryptUtil.matches(clearPassword, user.getPassword())) {
            throw new RuntimeException("invalid user/password");
        }
        return user;

    }

}
