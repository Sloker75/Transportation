package com.example.transportation_company.entity;

import com.example.transportation_company.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cargoes")
public class Cargo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String itemName;
    private double weight;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private int quantity;

    @ManyToOne()
    private Delivery delivery;
}
