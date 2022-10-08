package com.example.transportation_company.dto;

import com.example.transportation_company.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDataDto {
    private Long id;
    private String email;
    private Role role;

}
