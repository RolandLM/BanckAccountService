package org.sid.banckaccountservice.controller;

import org.sid.banckaccountservice.dto.BankAccountDto;
import org.sid.banckaccountservice.entities.BankAccount;
import org.sid.banckaccountservice.enums.AccountType;
import org.sid.banckaccountservice.mappers.BankAccountMapper;
import org.sid.banckaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestControler {

    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    /**
     * Permet de récupérer tous les comptes
     *
     * @return liste des comptes
     */
    @GetMapping("/bankAccounts")
    public ResponseEntity<List<BankAccountDto>> getBankAccounts() {
        var listAccount = bankAccountMapper.entitiesToDtos(bankAccountRepository.findAll());
        return ResponseEntity.ok(listAccount);
    }

    /**
     * Permet de récupérer les comptes par Type
     *
     * @return liste des comptes par Type
     */
    @GetMapping("/bankAccounts/type/{type}")
    public ResponseEntity<List<BankAccountDto>> getByType(@PathVariable AccountType type) {
        return ResponseEntity.ok(bankAccountMapper.entitiesToDtos(bankAccountRepository.findByType(type)));
    }

    /**
     * Permet de récupérer les comptes par ID
     *
     * @return BankAccount
     */
    @GetMapping("/bankAccounts/{id}")
    public ResponseEntity<BankAccountDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(bankAccountMapper.entityToDto(bankAccountRepository.findById(id).orElse(null)));
    }

    /**
     * Permet d'ajouter un compte
     *
     * @return BankAccount add ok
     */
    @PostMapping("/bankAccounts/save")
    public ResponseEntity<BankAccount> saveBankAccount(@RequestBody BankAccountDto bankAccountDto) {
        return new ResponseEntity<>(bankAccountRepository.save(
                bankAccountMapper.dtoToEntity(bankAccountDto)), HttpStatus.CREATED);
    }

    /**
     * Permet de mettre à jour un compte
     *
     * @return BankAccount modifier
     */
    @PutMapping("/bankAccounts/update")
    public ResponseEntity<BankAccount> update(@RequestBody BankAccountDto bankAccountDto) {
        return new ResponseEntity<>(bankAccountRepository.save(
                bankAccountMapper.dtoToEntity(bankAccountDto)), HttpStatus.CREATED);
    }

    /**
     * Permet de supprimer un compte
     *
     * @return BankAccount delete ok
     */
    @DeleteMapping("/bankAccounts/delete/{id}")
    public ResponseEntity<BankAccountDto> deleteById(@PathVariable String id) {
        var accountDto = bankAccountMapper.entityToDto(bankAccountRepository.findById(id).orElse(null));
        bankAccountRepository.deleteById(accountDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
