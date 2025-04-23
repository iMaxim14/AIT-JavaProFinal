package de.ait.javalessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // указывает на то, что данный класс является прорадителем таблицы в БД
public class BankAccount {


    @Id // указывает какое поле в лкассе будет первичным ключом (Primary Key)
    @GeneratedValue(strategy = GenerationType.AUTO) // автоматически генерирует ID (автоинкрементный ID)
    private Long id;

    private String accountNumber;

    private String ownerName;

    private double balance;


    public BankAccount() {

    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
