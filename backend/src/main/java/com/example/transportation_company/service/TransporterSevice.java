package com.example.transportation_company.service;

import com.example.transportation_company.dto.TransporterDto;
import com.example.transportation_company.entity.Customer;
import com.example.transportation_company.entity.Transporter;
import com.example.transportation_company.exception.EntityNotFoundException;
import com.example.transportation_company.mapper.Mapper;
import com.example.transportation_company.repository.CustomerRepository;
import com.example.transportation_company.repository.TransporterRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransporterSevice {

    private final TransporterRepository transporterRepository;
    private final Mapper mapper;

    public TransporterDto get(Long id){
        return mapper.toTransporterDto(retrieve(id));
    }

    public List<TransporterDto> getAll(){
        return transporterRepository.findAll().stream().map(mapper::toTransporterDto).toList();
    }

    public TransporterDto create(TransporterDto transporterDto){
        Transporter transporter = transporterRepository.save(mapper.toTransporter(transporterDto));
        return mapper.toTransporterDto(transporter);
    }

    public TransporterDto update(Long id, TransporterDto transporterDto){
        Transporter transporter = retrieve(id);

        transporter.setName(transporterDto.getName());
        transporter.setPhoneNumber(transporterDto.getPhoneNumber());

        Transporter update = transporterRepository.save(transporter);
        return mapper.toTransporterDto(update);
    }

    public void delete(Long id){
        transporterRepository.deleteById(id);
    }

    private Transporter retrieve(Long id){
        return transporterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transporter", id));
    }


}
