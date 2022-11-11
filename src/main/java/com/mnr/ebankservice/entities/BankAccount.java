package com.mnr.ebankservice.entities;

import com.mnr.ebankservice.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class BankAccount {
    @Id

    private String id;
    private Date createdAt;
    //double: default value= 0, Double: default value= null
    private Double balance;
    private String currency;

    @Enumerated(EnumType.STRING)
    private  AccountType type;


}