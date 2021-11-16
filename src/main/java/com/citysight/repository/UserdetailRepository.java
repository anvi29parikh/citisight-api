package com.citysight.repository;

import com.citysight.dto.AccountDto;
import com.citysight.dto.UpdateDto;
import com.citysight.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface UserdetailRepository extends JpaRepository<Account, Integer> {



    /*String s1 = null;
    @Query("select new com.citysight.dto.AccountDto(ac.accountId, ac.email, ac.fname, ac.lname, ac.role, ac.address) from Account ac where ac.email = 'harshil@citysight.com'")
    List<AccountDto> fetchUserDetailsDto();*/

    @Query("SELECT new com.citysight.dto.AccountDto(ac.accountId, ac.email, ac.fname, ac.lname, ac.role, ac.address) from Account ac WHERE ac.email = ?1")
     List<AccountDto> fetchUserDetailsDto(String email);

    @Modifying
    @Transactional
    @Query("update Account a set a.email=?1, a.fname=?2, a.lname=?3, a.address=?4 where a.accountId=?5")
   void updatedUser(String email,String fname, String lname, String address, Integer id);

}