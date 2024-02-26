package com.myBank.myBankapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long customer_id;

    @Column(nullable = false, unique = true)
    private String login;

    private String passhash;
    private String name;
    private String email;
    private LocalDate registration_date;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts;

}
