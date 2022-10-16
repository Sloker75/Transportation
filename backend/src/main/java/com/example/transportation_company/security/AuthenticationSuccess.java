package com.example.transportation_company.security;

import com.example.transportation_company.dto.AuthDataDto;
import com.example.transportation_company.mapper.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

@RequiredArgsConstructor
@Component
public class AuthenticationSuccess implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;
    private final Mapper mapper;
    private final SecurityService securityService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding(Charset.defaultCharset().name());
        objectMapper.writeValue(response.getWriter(), mapper.toAuthDataDto(securityService.getUser()));
    }
}
