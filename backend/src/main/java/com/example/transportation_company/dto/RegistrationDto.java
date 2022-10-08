package com.example.transportation_company.dto;

import com.example.transportation_company.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private String email;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String password;
    private Role role;
}
