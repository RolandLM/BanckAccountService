package org.sid.banckaccountservice.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import org.sid.banckaccountservice.enums.AccountType;

import java.util.Date;

@Getter
@Setter
@Builder
public class BankAccountDto {

    private String id;
    private Date dateCreation;
    private Double balance;
    private String currency;
    private AccountType type;
}
