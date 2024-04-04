package org.sid.banckaccountservice.web;

import org.sid.banckaccountservice.entities.BankAccount;
import org.sid.banckaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestControler {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankaccounts() { return bankAccountRepository.findAll();}

}
