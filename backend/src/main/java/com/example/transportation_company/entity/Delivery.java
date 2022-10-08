package com.example.transportation_company.entity;

import com.example.transportation_company.enums.State;
import com.example.transportation_company.enums.Unit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deliveries")
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "address_country")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "street", column = @Column(name = "address_street"))
    })
    private Address address;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "destination_country")),
            @AttributeOverride(name = "city", column = @Column(name = "destination_city")),
            @AttributeOverride(name = "street", column = @Column(name = "destination_street"))
    })
    private Address destination;

    @Enumerated(EnumType.STRING)
    private State state;
    private String description;
    //    Time
    private LocalDateTime creationDate;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;


    @ManyToOne()
    private Customer customer;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY)
    private List<Offer> offers;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY)
    private List<Cargo> cargoes;

}
