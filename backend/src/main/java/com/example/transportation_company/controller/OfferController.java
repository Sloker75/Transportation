package com.example.transportation_company.controller;

import com.example.transportation_company.dto.OfferDto;
import com.example.transportation_company.entity.Offer;
import com.example.transportation_company.entity.Transporter;
import com.example.transportation_company.service.OfferService;
import com.example.transportation_company.service.TransporterSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/offers")
public class OfferController {
    private final OfferService offerService;

    @GetMapping
    public List<OfferDto> getAll(){
        return offerService.getAll();
    }

    @GetMapping("/{id}")
    public OfferDto get(@PathVariable Long id){
        return offerService.get(id);
    }

    @PostMapping
    public OfferDto create(@RequestBody OfferDto offerDto){
        return offerService.create(offerDto);
    }

    @PutMapping("/{id}")
    public OfferDto update(@PathVariable Long id, @RequestBody OfferDto offerDto){
        return offerService.update(id, offerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        offerService.delete(id);
    }

}
