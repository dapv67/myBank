package com.myBank.myBankapp.repository;

import com.myBank.myBankapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {
}
