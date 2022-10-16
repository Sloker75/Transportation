package com.example.transportation_company.security;

import com.example.transportation_company.entity.AuthData;
import com.example.transportation_company.repository.AuthDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SecurityService {
    private final AuthDataRepository authDataRepository;

    public AuthData getUser() {
        return this.authDataRepository.findByEmail(getCurrentUserEmail()).orElseThrow();
    }

    public String getCurrentUserEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
