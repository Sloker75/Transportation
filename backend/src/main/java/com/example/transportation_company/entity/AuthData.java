package com.example.transportation_company.entity;

import com.example.transportation_company.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authorizations")
public class AuthData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(columnDefinition = "boolean default true")
    private boolean enabled = true;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Transporter transporter;

}
