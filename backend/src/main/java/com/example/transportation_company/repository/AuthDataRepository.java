package com.example.transportation_company.repository;

import com.example.transportation_company.entity.AuthData;
import com.example.transportation_company.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthDataRepository  extends JpaRepository<AuthData, Long> {
    Optional<AuthData> findByEmail(String email);
}
