package com.mnr.ebankservice.entities;

import com.mnr.ebankservice.entities.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

//http://localhost:8081/bankAccounts?projection=p1
//donne slm l'id et type et balance

@Projection(types = BankAccount.class,name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
