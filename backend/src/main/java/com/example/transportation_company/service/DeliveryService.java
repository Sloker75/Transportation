package com.example.transportation_company.service;

import com.example.transportation_company.dto.DeliveryDto;
import com.example.transportation_company.entity.Customer;
import com.example.transportation_company.entity.Delivery;
import com.example.transportation_company.exception.EntityNotFoundException;
import com.example.transportation_company.mapper.Mapper;
import com.example.transportation_company.repository.CustomerRepository;
import com.example.transportation_company.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeliveryService {
    private final CustomerRepository customerRepository;
    private final DeliveryRepository deliveryRepository;
    private final Mapper mapper;

    public DeliveryDto get(Long id){
        return mapper.toDeliveryDto(retrieve(id));
    }

    public List<DeliveryDto> getAll(){
        return deliveryRepository.findAll().stream().map(mapper::toDeliveryDto).toList();
    }

    public DeliveryDto create(DeliveryDto deliveryDto){
        Delivery delivery = mapper.toDelivery(deliveryDto);
        Customer customer = customerRepository.findById(deliveryDto.getCustomer().getId()).orElseThrow(() -> new EntityNotFoundException("Delivery", delivery.getId()));

        delivery.setCustomer(customer);

        return mapper.toDeliveryDto(deliveryRepository.save(delivery));
    }

    public DeliveryDto update(Long id, DeliveryDto deliveryDto){
        Delivery delivery = retrieve(id);

        delivery.setAddress(deliveryDto.getAddress());
        delivery.setDestination(deliveryDto.getDestination());

        delivery.setState(deliveryDto.getState());
        delivery.setDescription(deliveryDto.getDescription());

        delivery.setCreationDate(deliveryDto.getCreationDate());
        delivery.setDepartureDate(deliveryDto.getDepartureDate());
        delivery.setArrivalDate(deliveryDto.getArrivalDate());


        Delivery update = deliveryRepository.save(delivery);

        return mapper.toDeliveryDto(update);

    }

    public void delete(Long id){
        deliveryRepository.deleteById(id);
    }

    private Delivery retrieve(Long id){
        return deliveryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Delivery", id));
    }

}
