package com.example.transportation_company.service;

import com.example.transportation_company.dto.AuthDataDto;
import com.example.transportation_company.dto.RegistrationDto;
import com.example.transportation_company.entity.AuthData;
import com.example.transportation_company.entity.Customer;
import com.example.transportation_company.entity.Transporter;
import com.example.transportation_company.mapper.Mapper;
import com.example.transportation_company.repository.AuthDataRepository;
import com.example.transportation_company.repository.CustomerRepository;
import com.example.transportation_company.repository.TransporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthDataRepository authDataRepository;
    private final CustomerRepository customerRepository;
    private final TransporterRepository transporterRepository;
    private final Mapper mapper;
    private final PasswordEncoder passwordEncoder;

    public AuthDataDto signup(RegistrationDto registrationDto) {
        AuthData authData = new AuthData();
        authData.setEmail(registrationDto.getEmail());
        authData.setRole(registrationDto.getRole());
        authData.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        if (registrationDto.getRole().toString() == "USER"){
            Customer customer = mapper.toCustomer(registrationDto);
            customer = customerRepository.save(customer);
            authData.setCustomer(customer);
            authData = authDataRepository.save(authData);
            return mapper.toAuthDataDto(authData);
        }
        else {
            Transporter transporter = mapper.toTransporter(registrationDto);
            transporter = transporterRepository.save(transporter);
            authData.setTransporter(transporter);
            authData = authDataRepository.save(authData);
            return mapper.toAuthDataDto(authData);
        }
    }


    public boolean verification(AuthDataDto authDto) {
        if (authDataRepository.findByEmail(authDto.getEmail()).isEmpty()) return false;
        return true;
    }
}
