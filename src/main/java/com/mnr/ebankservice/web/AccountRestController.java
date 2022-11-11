package com.mnr.ebankservice.web;


import com.mnr.ebankservice.dto.BankAccountRequestDTO;
import com.mnr.ebankservice.dto.BankAccountResponseDTO;
import com.mnr.ebankservice.entities.BankAccount;
import com.mnr.ebankservice.mappers.AccountMapper;
import com.mnr.ebankservice.repositories.BankAccountRepository;
import com.mnr.ebankservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;

    private AccountService accountService;

    private AccountMapper accountMapper;


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountList(){
        return  bankAccountRepository.findAll();
    }

    //@PathVariable: retrieve l'id du path
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){

        return  bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    //add: @RequestBody : objet sent via body
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return  accountService.addAccount(bankAccountRequestDTO);
    }

    //put(update all attributes) & patch (update some attributes)
    //@RequestBody:@RequestBody : objet sent via body
    @PutMapping("/bankAccounts/{id}")
    public  BankAccount updateAccount(@PathVariable String id,@RequestBody BankAccount bankAccount){
        //look for account tu update
        BankAccount account= bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("account to update not found"));

        /*if used: pour ne pas ecraser les valeurs existante avec des null au cas ou une parmis les donnes
        ne sont pa envoyées*/
        if(bankAccount.getBalance() !=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt() !=null) account.setCreatedAt(new Date());
        if(bankAccount.getCurrency() !=null) account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getType() !=null) account.setType(bankAccount.getType());

        return  bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

}


//min: 37