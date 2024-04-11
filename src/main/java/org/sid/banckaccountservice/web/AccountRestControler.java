package org.sid.banckaccountservice.web;

import org.sid.banckaccountservice.entities.BankAccount;
import org.sid.banckaccountservice.enums.AccountType;
import org.sid.banckaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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
    private BankAccountRepository bankAccountRepository;

    /**
     * Permet de récupérer tous les comptes
     *
     * @return liste des comptes
     */
    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts() {
        var list = bankAccountRepository.findAll();
        return list;
    }

    /**
     * Permet de récupérer les comptes par Type
     *
     * @return liste des comptes par Type
     */
    @GetMapping("/bankAccounts/type/{type}")
    public List<BankAccount> getBankAccountsByType(@PathVariable AccountType type) {
        return bankAccountRepository.findByType(type);
    }

    /**
     * Permet de récupérer les comptes par ID
     *
     * @return BankAccount
     */
    @GetMapping("/bankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    /**
     * Permet de d'ajouter un compte
     *
     * @return BankAccount add ok
     */
    @PostMapping("/bankAccounts/add")
    public BankAccount addBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    /**
     * Permet de mettre à jour un compte
     *
     * @return BankAccount modifier
     */
    @PutMapping("/bankAccounts/update")
    public BankAccount updateBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    /**
     * Permet de supprimer un compte
     *
     * @return BankAccount delete ok
     */
    @DeleteMapping("/bankAccounts/delete/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
