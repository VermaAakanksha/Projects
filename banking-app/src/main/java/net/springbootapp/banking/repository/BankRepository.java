package net.springbootapp.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springbootapp.banking.Entity.Account;

public interface BankRepository extends JpaRepository<Account,Long>{

}
