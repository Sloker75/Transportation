package com.example.transportation_company.dto;

import com.example.transportation_company.entity.Delivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;

    private List<DeliveryShortDto> deliveries;

    private AuthDataDto authData;

}
