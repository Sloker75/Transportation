package com.example.transportation_company.controller;

import com.example.transportation_company.dto.AuthDataDto;
import com.example.transportation_company.dto.RegistrationDto;
import com.example.transportation_company.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("signup")
    public AuthDataDto signup(@RequestBody RegistrationDto registrationDto){
        return authService.signup(registrationDto);
    }

    @PostMapping("verification")
    public boolean verification(@RequestBody AuthDataDto authDto){
        return authService.verification(authDto);
    }


}
