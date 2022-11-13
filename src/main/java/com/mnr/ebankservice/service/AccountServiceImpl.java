package com.mnr.ebankservice.service;

import com.mnr.ebankservice.dto.BankAccountRequestDTO;
import com.mnr.ebankservice.dto.BankAccountResponseDTO;
import com.mnr.ebankservice.entities.BankAccount;
import com.mnr.ebankservice.mappers.AccountMapper;
import com.mnr.ebankservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.UUID;

//import @Transactional of spring
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        //faire ses operations  avec modelMapper ou mapStract
        //transfert dto vers entity
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .type(bankAccountRequestDTO.getType())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        //return responseDTO
//        BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
//                .id(savedBankAccount.getId())
//                .createdAt(savedBankAccount.getCreatedAt())
//                .currency(savedBankAccount.getCurrency())
//                .type(savedBankAccount.getType())
//                .balance(savedBankAccount.getBalance())
//                .build();
        //remplacer code precedent par(using mapper:
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);

        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        //faire ses operations  avec modelMapper ou mapStract
        //transfert dto vers entity
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .type(bankAccountRequestDTO.getType())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);

        return bankAccountResponseDTO;
    }
}
