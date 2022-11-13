package com.mnr.ebankservice.dto;

import com.mnr.ebankservice.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountRequestDTO {

    private Double balance;
    private String currency;

    //@Enumerated: pr ecrire type en string et pas en index(1,2,3..)
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
