package com.mnr.ebankservice.repositories;

import com.mnr.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
