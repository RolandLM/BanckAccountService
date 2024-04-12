package org.sid.banckaccountservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sid.banckaccountservice.dto.BankAccountDto;
import org.sid.banckaccountservice.entities.BankAccount;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    @Mapping(source = "bankAccount.createAt", target = "dateCreation")
    BankAccountDto entityToDto(BankAccount bankAccount);

    @Mapping(source = "dateCreation", target = "createAt")
    BankAccount dtoToEntity(BankAccountDto bankAccountDto);

    List<BankAccountDto> entitiesToDtos(List<BankAccount> bankAccountList);
}
