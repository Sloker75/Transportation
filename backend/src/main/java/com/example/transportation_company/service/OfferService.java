package com.example.transportation_company.service;

import com.example.transportation_company.dto.OfferDto;
import com.example.transportation_company.entity.Delivery;
import com.example.transportation_company.entity.Offer;
import com.example.transportation_company.entity.Transporter;
import com.example.transportation_company.exception.EntityNotFoundException;
import com.example.transportation_company.mapper.Mapper;
import com.example.transportation_company.repository.DeliveryRepository;
import com.example.transportation_company.repository.OfferRepository;
import com.example.transportation_company.repository.TransporterRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final TransporterRepository transporterRepository;
    private final DeliveryRepository deliveryRepository;
    private final Mapper mapper;


    public OfferDto get(Long id){
        return mapper.toOfferDto(retrieve(id));
    }

    public List<OfferDto> getAll(){
        return offerRepository.findAll().stream().map(mapper::toOfferDto).toList();
    }

    public OfferDto create(OfferDto offerDto){
        Offer offer = mapper.toOffer(offerDto);
        Transporter transporter = transporterRepository.findById(offerDto.getTransporter().getId()).orElseThrow(() -> new EntityNotFoundException("Offer", offer.getId()));
        Delivery delivery = deliveryRepository.findById(offerDto.getDelivery().getId()).orElseThrow(() -> new EntityNotFoundException("Offer", offer.getId()));

        offer.setTransporter(transporter);
        offer.setDelivery(delivery);

        return mapper.toOfferDto(offerRepository.save(offer));
    }

    public OfferDto update(Long id, OfferDto offerDto){
        Offer offer = retrieve(id);

        offer.setPrice(offerDto.getPrice());
        offer.setTransportationInfo(offerDto.getTransportationInfo());
        offer.setState(offerDto.getState());

        Offer update = offerRepository.save(offer);
        return mapper.toOfferDto(update);
    }

    public void delete(Long id){offerRepository.deleteById(id);}

    private Offer retrieve(Long id){
        return offerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Offer", id));
    }


}
