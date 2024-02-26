package com.myBank.myBankapp.service;

import com.myBank.myBankapp.entity.CustomerEntity;
import com.myBank.myBankapp.entity.EmployeeEntity;
import com.myBank.myBankapp.repository.CustomerRepository;
import com.myBank.myBankapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    /*public List<CustomerEntity>findByName(String name){
        customerRepository.findByName();
    }*/
    public List<EmployeeEntity> getAll() {
        return (List<EmployeeEntity>) this.employeeRepository.findAll();
    }
    public EmployeeEntity save(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }





}
