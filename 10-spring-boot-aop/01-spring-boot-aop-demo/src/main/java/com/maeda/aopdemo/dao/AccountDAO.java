package com.maeda.aopdemo.dao;

import com.maeda.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
