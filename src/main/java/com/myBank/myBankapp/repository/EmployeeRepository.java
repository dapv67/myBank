package com.myBank.myBankapp.repository;

import com.myBank.myBankapp.entity.CustomerEntity;
import com.myBank.myBankapp.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {

}
