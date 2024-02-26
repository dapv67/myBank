package com.myBank.myBankapp.web.controller;

import com.myBank.myBankapp.entity.CustomerEntity;
import com.myBank.myBankapp.entity.EmployeeEntity;
import com.myBank.myBankapp.service.CustomerService;
import com.myBank.myBankapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAll(){
        return ResponseEntity.ok(this.employeeService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeEntity> save(@RequestBody EmployeeEntity employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }


}
