package com.mnr.ebankservice;

import com.fasterxml.classmate.AnnotationOverrides;
import com.mnr.ebankservice.entities.BankAccount;
import com.mnr.ebankservice.entities.enums.AccountType;
import com.mnr.ebankservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    /*
     -immutable Universally Unique Identifier (UUID)
     -Builder is a creational design pattern that lets you construct complex
     objects step by step. The pattern allows you to produce different types and
      representations of an object using the same construction code.

  */
//    @Bean
//    CommandLineRunner start(BankAccountRepository bankAccountRepository){
//        return args -> {
//
//            bankAccountRepository.deleteAll(); //vider les categories a chaque demarrage
//
//           BankAccount bankAccount1= new BankAccount(null,new Date(),125,"MAD",AccountType.CURRENT_ACCOUNT);
//
//
//           bankAccountRepository.save(bankAccount1);
//
//
//
//        };
//    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {
            for (int i=0;i<10;i++){
                BankAccount bankAccount= BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .balance(1000 + Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();


                bankAccountRepository.save(bankAccount);

            }
        };
    }




}
