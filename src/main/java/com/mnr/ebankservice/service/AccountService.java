package com.mnr.ebankservice.service;

import com.mnr.ebankservice.dto.BankAccountRequestDTO;
import com.mnr.ebankservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
