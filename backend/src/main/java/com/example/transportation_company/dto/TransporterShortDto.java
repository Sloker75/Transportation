package com.example.transportation_company.dto;

import com.example.transportation_company.entity.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransporterShortDto {
    private Long id;
    private String phoneNumber;
    private String name;

    private AuthDataDto authData;

}



