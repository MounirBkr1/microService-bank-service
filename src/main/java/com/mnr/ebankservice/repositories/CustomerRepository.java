package com.mnr.ebankservice.repositories;

import com.mnr.ebankservice.entities.BankAccount;
import com.mnr.ebankservice.entities.Customer;
import com.mnr.ebankservice.entities.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
