package com.example.transportation_company.service;

import com.example.transportation_company.dto.CustomerDto;
import com.example.transportation_company.entity.Customer;
import com.example.transportation_company.exception.EntityNotFoundException;
import com.example.transportation_company.mapper.Mapper;
import com.example.transportation_company.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final Mapper mapper;

    public CustomerDto get(Long id){
        return mapper.toCustomerDto(retrieve(id));
    }

    public Page<CustomerDto> getAll(Pageable pageable){
        return customerRepository.findAll(pageable).map(mapper::toCustomerDto);
    }

    public CustomerDto create(CustomerDto customerDto){
        Customer customer = customerRepository.save(mapper.toCustomer(customerDto));
        return mapper.toCustomerDto(customer);
    }

    public CustomerDto update(Long id, CustomerDto customerDto){
        Customer customer = retrieve(id);
        mapper.mergeCustomer(customerDto, customer);
        return mapper.toCustomerDto(customerRepository.save(customer));
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }

    private Customer retrieve(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer", id));
    }


}
