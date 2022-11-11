package com.mnr.ebankservice.repositories;

import com.mnr.ebankservice.entities.BankAccount;
import com.mnr.ebankservice.entities.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    //with spring data rest
    // http://localhost:8081/bankAccounts/search/findByType?type=SAVING_ACCOUNT
    //List<BankAccount> findByType(AccountType type);


    // http://localhost:8081/bankAccounts/search/byType?t=SAVING_ACCOUNT
    @RestResource(path="/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
