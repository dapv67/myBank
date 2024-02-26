package com.myBank.myBankapp.service;

import com.myBank.myBankapp.entity.CustomerEntity;
import com.myBank.myBankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /*public List<CustomerEntity>findByName(String name){
        customerRepository.findByName();
    }*/
    public List<CustomerEntity> getAll() {
        return (List<CustomerEntity>) this.customerRepository.findAll();
    }
    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }





}
