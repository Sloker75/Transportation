package com.example.transportation_company.controller;

import com.example.transportation_company.dto.TransporterDto;
import com.example.transportation_company.entity.Transporter;
import com.example.transportation_company.service.TransporterSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transporters")
public class TransporterController {
    private final TransporterSevice transporterSevice;

    @GetMapping
    public List<TransporterDto> getAll(){
        return transporterSevice.getAll();
    }

    @GetMapping("/{id}")
    public TransporterDto get(@PathVariable Long id){
        return transporterSevice.get(id);
    }

    @PostMapping
    public TransporterDto create(@RequestBody TransporterDto transporterDto){
        return transporterSevice.create(transporterDto);
    }

    @PutMapping("/{id}")
    public TransporterDto update(@PathVariable Long id, @RequestBody TransporterDto transporterDto){
        return transporterSevice.update(id, transporterDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        transporterSevice.delete(id);
    }
}
