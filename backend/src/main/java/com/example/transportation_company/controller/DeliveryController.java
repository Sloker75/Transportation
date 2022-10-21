package com.example.transportation_company.controller;

import com.example.transportation_company.dto.DeliveryDto;
import com.example.transportation_company.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping
    public Page<DeliveryDto> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return deliveryService.getAll(pageable);
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
