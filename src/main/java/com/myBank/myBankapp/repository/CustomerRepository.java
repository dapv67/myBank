package com.myBank.myBankapp.repository;

import com.myBank.myBankapp.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {

}
