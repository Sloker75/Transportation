package com.example.transportation_company.controller;

import com.example.transportation_company.dto.CustomerDto;
import com.example.transportation_company.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public Page<CustomerDto> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return customerService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public CustomerDto get(@PathVariable Long id){
        return customerService.get(id);
    }

    @PostMapping
    public CustomerDto create(@RequestBody CustomerDto customerDto){
        return customerService.create(customerDto);
    }

    @PutMapping("/{id}")
    public CustomerDto update(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        return customerService.update(id, customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }

}
