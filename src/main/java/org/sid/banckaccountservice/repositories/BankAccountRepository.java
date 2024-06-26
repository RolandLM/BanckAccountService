package org.sid.banckaccountservice.repositories;

import org.sid.banckaccountservice.entities.BankAccount;
import org.sid.banckaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.List;

@RepositoryRestResource //annotation juste pour les tests
public interface BankAccountRepository extends JpaRepository <BankAccount, String> {
    @RestResource(path = "/bytype")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
