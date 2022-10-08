package com.example.transportation_company.dto;

import com.example.transportation_company.entity.Delivery;
import com.example.transportation_company.entity.Transporter;
import com.example.transportation_company.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {
    private Long id;
    private String transportationInfo;
    private double price;
    private State state;

    private TransporterShortDto transporter;

    private DeliveryShortDto delivery;
}
