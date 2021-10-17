package com.citysight.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citysight.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	Optional<Account> findByEmail(String email);

	
	@Query
	(value = "SELECT c from Account c")
	List<Account> listuser();
	
	
	
}
