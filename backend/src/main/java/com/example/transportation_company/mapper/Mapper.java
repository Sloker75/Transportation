package com.example.transportation_company.mapper;

import com.example.transportation_company.dto.*;
import com.example.transportation_company.entity.*;
import org.apache.catalina.User;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Mapper {

    CustomerDto toCustomerDto(Customer entity);
    @Mapping(target = "deliveries", ignore = true)
    @Mapping(target = "authData", ignore = true)
    Customer toCustomer(CustomerDto dto);
    Customer toCustomer(RegistrationDto dto);
    @Mapping(target = "id", ignore = true)
    void mergeCustomer(CustomerDto dto, @MappingTarget Customer entity);

    TransporterDto toTransporterDto(Transporter entity);
    @Mapping(target = "authData", ignore = true)
    @Mapping(target = "offers", ignore = true)
    Transporter toTransporter(TransporterDto dto);
    Transporter toTransporter(RegistrationDto dto);


    DeliveryDto toDeliveryDto(Delivery entity);
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "offers", ignore = true)
    Delivery toDelivery(DeliveryDto dto);

    OfferDto toOfferDto(Offer entity);
    @Mapping(target = "transporter", ignore = true)
    @Mapping(target = "delivery", ignore = true)
    Offer toOffer(OfferDto dto);

    AuthDataDto toAuthDataDto(AuthData entity);
    AuthData toAuthData(AuthDataDto dto);

    CargoDto toCargoDto(Cargo entity);
    @Mapping(target = "delivery", ignore = true)
    Cargo toCargo(CargoDto dto);


}
