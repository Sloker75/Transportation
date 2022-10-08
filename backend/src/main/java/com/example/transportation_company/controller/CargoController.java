package com.example.transportation_company.controller;

import com.example.transportation_company.dto.CargoDto;
import com.example.transportation_company.dto.CustomerDto;
import com.example.transportation_company.service.CargoService;
import com.example.transportation_company.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cargoes")
public class CargoController {
    private final CargoService cargoService;

    @GetMapping
    public List<CargoDto> getAll(){
        return cargoService.getAll();
    }

    @GetMapping("/{id}")
    public CargoDto get(@PathVariable Long id){
        return cargoService.get(id);
    }

    @PostMapping
    public CargoDto create(@RequestBody CargoDto cargoDto){
        return cargoService.create(cargoDto);
    }

    @PutMapping("/{id}")
    public CargoDto update(@PathVariable Long id, @RequestBody CargoDto cargoDto){
        return cargoService.update(id, cargoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cargoService.delete(id);
    }
}
