package com.maeda.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOIMpl implements MembershipDAO {

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A SILLY MEMBER ACCOUNT");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": im going to sleep rn");

    }
}
