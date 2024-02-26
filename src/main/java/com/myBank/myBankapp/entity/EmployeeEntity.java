package com.myBank.myBankapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String passhash;

    @OneToMany(mappedBy = "teller", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions;
    // Constructors, Getters, and Setters
}
