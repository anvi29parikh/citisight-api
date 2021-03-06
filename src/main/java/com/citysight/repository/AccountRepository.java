package com.citysight.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citysight.dto.AccountDto;
import com.citysight.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	Optional<Account> findByEmail(String email);



	@Query("select new com.citysight.dto.AccountDto(ac.accountId, ac.email, ac.fname, ac.lname, ac.role, ac.address) from Account ac")
	List<AccountDto> fetchAllAccountDtos();


}
