package com.mecaps.blogApp.controller;

import com.mecaps.blogApp.requestDTO.LoginRequestDTO;
import com.mecaps.blogApp.service.AuthService;
import com.mecaps.blogApp.serviceImpl.AuthServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthControlleer {
    private final AuthServiceImpl authService;

    public AuthControlleer(AuthServiceImpl authService) {
        this.authService = authService;
    }
    @PostMapping("/login")
    public Map<String,String> login (LoginRequestDTO requestDTO){
        return authService.loginUser(requestDTO);
    }
}
