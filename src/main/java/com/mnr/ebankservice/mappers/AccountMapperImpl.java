package com.mnr.ebankservice.mappers;

import com.mnr.ebankservice.dto.BankAccountResponseDTO;
import com.mnr.ebankservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
//@Component ou @Service
@Component
public class AccountMapperImpl implements AccountMapper {
    @Override
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        //transferer donnees de bankAccount vers bankAccountResponseDTO
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
