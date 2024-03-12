package com.myBank.myBankapp.web.controller;

import com.myBank.myBankapp.entity.CustomerEntity;
import com.myBank.myBankapp.exception.EmailSendingException;
import com.myBank.myBankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/hi")
    public String hi(){
        return "Hola";
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAll(){
        return ResponseEntity.ok(this.customerService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<CustomerEntity> save(@RequestBody CustomerEntity customer) {
        if(customer.getEmail().isEmpty()){
            throw new EmailSendingException("Email is required",HttpStatus.BAD_REQUEST.value());
        }
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }


}
