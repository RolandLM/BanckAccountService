package org.sid.banckaccountservice;

import org.sid.banckaccountservice.entities.BankAccount;
import org.sid.banckaccountservice.enums.AccountType;
import org.sid.banckaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.Date;

@SpringBootApplication
public class BanckAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanckAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for (int i = 0; i < 5; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.balance(1000 + Math.random() * 120000)
						.createAt(new Date())
						.currency("FCFA")
						.build();

				bankAccountRepository.save(bankAccount);
			}
		};
	}

}
