package com.maeda.aopdemo.dao;

import com.maeda.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
    List<Account> findAccounts();
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);

    List<Account> findAccounts(boolean tripwire);
}
