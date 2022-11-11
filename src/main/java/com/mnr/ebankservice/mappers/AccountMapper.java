package com.mnr.ebankservice.mappers;

import com.mnr.ebankservice.dto.BankAccountResponseDTO;
import com.mnr.ebankservice.entities.BankAccount;

public interface AccountMapper {
    BankAccountResponseDTO fromBankAccount(BankAccount bankAccount);
}
