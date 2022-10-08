package com.example.transportation_company.dto;


import com.example.transportation_company.entity.Address;
import com.example.transportation_company.entity.Cargo;
import com.example.transportation_company.enums.State;
import com.example.transportation_company.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {
    private Long Id;

    private Address address;
    private Address destination;

    private State state;
    private String description;

    private LocalDateTime creationDate;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    private CustomerShortDto customer;

    private List<OfferDto> offers;

    private List<CargoDto> cargoes;

}
