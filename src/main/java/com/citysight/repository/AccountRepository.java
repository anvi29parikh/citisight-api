package com.citysight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citysight.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
