package com.mnr.ebankservice.web;

import com.mnr.ebankservice.dto.BankAccountRequestDTO;
import com.mnr.ebankservice.dto.BankAccountResponseDTO;
import com.mnr.ebankservice.entities.BankAccount;
import com.mnr.ebankservice.entities.Customer;
import com.mnr.ebankservice.repositories.BankAccountRepository;
import com.mnr.ebankservice.repositories.CustomerRepository;
import com.mnr.ebankservice.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//to use graphql: http://localhost:8081/graphiql

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerRepository customerRepository;

    //accountsList: meme nom sur file ressources/schema.graphqls
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }


    //@Argument: c est un argument
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));
    }

    // @MutationMapping: for modification "add or update"
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
         bankAccountRepository.deleteById(id);
         return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return  customerRepository.findAll();
    }

}


