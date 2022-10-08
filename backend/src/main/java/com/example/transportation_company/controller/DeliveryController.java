package com.example.transportation_company.controller;

import com.example.transportation_company.dto.DeliveryDto;
import com.example.transportation_company.entity.Delivery;
import com.example.transportation_company.entity.Offer;
import com.example.transportation_company.service.DeliveryService;
import com.example.transportation_company.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping
    public List<DeliveryDto> getAll(){
        return deliveryService.getAll();
    }

    @GetMapping("/{id}")
    public DeliveryDto get(@PathVariable Long id){
        return deliveryService.get(id);
    }

    @PostMapping
    public DeliveryDto create(@RequestBody DeliveryDto deliveryDto){
        return deliveryService.create(deliveryDto);
    }

    @PutMapping("/{id}")
    public DeliveryDto update(@PathVariable Long id, @RequestBody DeliveryDto deliveryDto){
        return deliveryService.update(id, deliveryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        deliveryService.delete(id);
    }
}
