package com.maeda.aopdemo.dao;

import com.maeda.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doing work");
        return false;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    public String getName() {
        System.out.println(getClass() + ": get name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": set name to " + name);
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": get service code");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": set service code to " + serviceCode);
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripwire) {
        List<Account> accounts = new ArrayList<>();

        // for academic purposes simulate exception

        if (tripwire) {
            throw new RuntimeException("No soup 4 u");
        }


        // create accounts

        Account account = new Account("Chad Darby", "Platinum");
        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Gold");

        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);

        return accounts;
    }
}
