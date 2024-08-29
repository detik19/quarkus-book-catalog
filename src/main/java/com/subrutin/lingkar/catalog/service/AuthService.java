package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.dto.LoginRequestDTO;
import com.subrutin.lingkar.catalog.dto.LoginResponseDTO;

public interface AuthService {

    public LoginResponseDTO login(LoginRequestDTO dto);

}
