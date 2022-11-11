package com.mnr.ebankservice.dto;

import com.mnr.ebankservice.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


//qdj enregistre un compte, j envoie la reponse
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
