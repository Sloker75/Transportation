package com.example.transportation_company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerShortDto {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;

    private AuthDataDto authData;
}
