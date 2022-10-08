package com.example.transportation_company.entity;

import com.example.transportation_company.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "offers")
public class Offer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String transportationInfo;
    private double price;
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne()
    private Transporter transporter;

    @ManyToOne()
    private Delivery delivery;

}
