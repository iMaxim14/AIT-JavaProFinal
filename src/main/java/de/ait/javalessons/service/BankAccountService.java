package de.ait.javalessons.service;

import de.ait.javalessons.model.BankAccount;
import de.ait.javalessons.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // используется для пометки классов сервисного слоя (бизнес-логики)
@Slf4j // автоматически создаст объект логгера "log"
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    @Value("${bank.min-balance:0.0}")
    private double minBalance;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> findBankAccountById(long id) {
        log.info("Find bank account by id: {}", id);
        return bankAccountRepository.findById(id);
    }

    public BankAccount saveNewBankAccount(BankAccount bankAccount) {
        log.info("Save new bank account: {}", bankAccount);
        return bankAccountRepository.save(bankAccount);
    }

    @Transactional
    // все операции внутри метода выполняются как одна транзакция — либо все выполняются, либо все отменяются в случае ошибки
    public double deposit(double amount, Long bankAccountId) {
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Bank account with id " + bankAccountId + " not found"));
        if (amount <= 0) {
            log.error("Amount must be greater than 0");
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return savedBankAccount.getBalance();
    }

    @Transactional
    public double withdraw(double amount, Long bankAccountId) {
        log.info("Deposit amount: {}", amount);
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Bank account " + bankAccountId + "not found"));
        if (bankAccount.getBalance() <= 0) {
            log.error("Amount must be greater than 0");
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount > bankAccount.getBalance()) {
            log.error("Amount is greater than bank account balance");
            throw new IllegalArgumentException("Amount is greater than bank account balance");
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
            return savedBankAccount.getBalance();
        }
    }
}
