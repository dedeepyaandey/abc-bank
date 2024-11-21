package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

     @Test
    public void maxi_savings_account_test1() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SUPER_SAVINGS);
        bank.addCustomer(new Customer("Bob").openAccount(checkingAccount));

        checkingAccount.deposit(2500.0);

        assertEquals(290.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

     @Test
    public void maxi_savings_account_test2() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SUPER_SAVINGS);
        bank.addCustomer(new Customer("Alice").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(75.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

     @Test
    public void maxi_savings_account_test3() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SUPER_SAVINGS);
        bank.addCustomer(new Customer("Alex").openAccount(checkingAccount));

        checkingAccount.deposit(500.0);

        assertEquals(20.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }


}
