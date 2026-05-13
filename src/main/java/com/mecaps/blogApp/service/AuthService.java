package com.mecaps.blogApp.service;

import com.mecaps.blogApp.requestDTO.LoginRequestDTO;

import java.util.Map;

public interface AuthService {
    Map <String ,String> loginUser (LoginRequestDTO requestDTO);
}
