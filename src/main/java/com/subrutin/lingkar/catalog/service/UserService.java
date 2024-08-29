package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.domain.User;
import com.subrutin.lingkar.catalog.dto.UserCreateRequestDTO;

public interface UserService {

    public void createUser(UserCreateRequestDTO dto);

    public User authenticateUser(String username, String password);
}
