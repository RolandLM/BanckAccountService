package org.sid.banckaccountservice.mappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sid.banckaccountservice.dto.BankAccountDto;
import org.sid.banckaccountservice.entities.BankAccount;
import org.sid.banckaccountservice.enums.AccountType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class BankAccountMapperTest {

    @Test
    void entityToDto() {
        //Given
        BankAccount accountEntity = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(AccountType.SAVING_ACCOUNT)
                .createAt(new Date())
                .balance(1000 + Math.random() * 120000)
                .currency("EURO")
                .build();

        //When
        BankAccountDto accountDto = BankAccountMapper.INSTANCE.entityToDto(accountEntity);

        //Then
        assertNotNull(accountDto);
        assertEquals(accountEntity.getType(), accountDto.getType());
        assertEquals(accountEntity.getCreateAt(), accountDto.getDateCreation());
    }

    @Test
    void dtoToEntity() {
        //Given
        BankAccountDto accountDto = BankAccountDto.builder()
                .id(UUID.randomUUID().toString())
                .type(AccountType.SAVING_ACCOUNT)
                .dateCreation(new Date())
                .balance(1000 + Math.random() * 120000)
                .currency("EURO")
                .build();

        //When
        BankAccount accountEntity = BankAccountMapper.INSTANCE.dtoToEntity(accountDto);

        //Then
        assertNotNull(accountEntity);
        assertEquals(accountDto.getType(), accountEntity.getType());
        assertEquals(accountDto.getDateCreation(), accountEntity.getCreateAt());
    }
}