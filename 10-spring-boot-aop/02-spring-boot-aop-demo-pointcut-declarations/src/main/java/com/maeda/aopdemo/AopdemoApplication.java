package com.maeda.aopdemo;


import com.maeda.aopdemo.dao.AccountDAO;
import com.maeda.aopdemo.dao.MembershipDAO;
import com.maeda.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.AbstractCollection;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            demoTheAroundAdvice(trafficFortuneService);
        };
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        String data = trafficFortuneService.getFortune();

        System.out.println("\nFortune is: " + data);

        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            // add boolean to simulate exc
            boolean tripwire = false;

            accounts = accountDAO.findAccounts(tripwire);

        } catch (Exception exc) {
            System.out.println("\n\n Main program caught exception: " + exc);
        }

        System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
        System.out.println("----------");
        System.out.println(accounts);
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            // add boolean to simulate exc
            boolean tripwire = true;

            accounts = accountDAO.findAccounts(tripwire);

        } catch (Exception exc) {
            System.out.println("\n\n Main program caught exception: " + exc);
        }

        System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
        System.out.println("----------");
        System.out.println(accounts);
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain program: demotheafterreturningadvice");
        System.out.println("----------");
        System.out.println(accounts);
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        account.setName("Medhu");
        account.setLevel("(Platinum");
        accountDAO.addAccount(account, true);
        membershipDAO.addSillyMember();

        accountDAO.doWork();
        membershipDAO.goToSleep();

        accountDAO.getName();
        accountDAO.setName("Name");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

    }
}
