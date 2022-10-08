package com.example.transportation_company.repository;

import com.example.transportation_company.entity.Customer;
import com.example.transportation_company.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
