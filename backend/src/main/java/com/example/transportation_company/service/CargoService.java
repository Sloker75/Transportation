package com.example.transportation_company.service;

import com.example.transportation_company.dto.CargoDto;
import com.example.transportation_company.entity.Cargo;
import com.example.transportation_company.entity.Delivery;
import com.example.transportation_company.exception.EntityNotFoundException;
import com.example.transportation_company.mapper.Mapper;
import com.example.transportation_company.repository.CargoRepository;
import com.example.transportation_company.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CargoService {
    private final CargoRepository cargoRepository;
    private final DeliveryRepository deliveryRepository;
    private final Mapper mapper;

    public List<CargoDto> getAll() {
        return cargoRepository.findAll().stream().map(mapper::toCargoDto).toList();
    }

    public CargoDto get(Long id) {
        return mapper.toCargoDto(retrieve(id));
    }

    public CargoDto create(CargoDto cargoDto) {
        Cargo cargo = mapper.toCargo(cargoDto);
        Delivery delivery = deliveryRepository.findById(cargoDto.getDelivery().getId()).orElseThrow(() -> new EntityNotFoundException("Cargo", cargo.getId()));

        cargo.setDelivery(delivery);

        return mapper.toCargoDto(cargoRepository.save(cargo));
    }


    public CargoDto update(Long id, CargoDto cargoDto) {
        Cargo cargo = retrieve(id);

        cargo.setItemName(cargoDto.getItemName());
        cargo.setWeight(cargoDto.getWeight());
        cargo.setQuantity(cargoDto.getQuantity());
        cargo.setUnit(cargoDto.getUnit());

        Cargo update = cargoRepository.save(cargo);
        return mapper.toCargoDto(update);
    }


    public void delete(Long id){
        cargoRepository.deleteById(id);
    }

    private Cargo retrieve(Long id){
        return cargoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cargo", id));
    }


}
