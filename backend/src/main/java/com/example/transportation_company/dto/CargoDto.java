package com.example.transportation_company.dto;

import com.example.transportation_company.entity.Delivery;
import com.example.transportation_company.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDto {
    private Long id;
    private String itemName;
    private double weight;
    private Unit unit;
    private int quantity;

    private DeliveryShortDto delivery;
}
