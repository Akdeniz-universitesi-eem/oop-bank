package com.oopbank.atm;

import com.oopbank.customer.Customer;

public interface IMoneyDrawable {

    public void withdrawMoney(Customer customer, Double amountOfMoneyToWithdraw);

    public void depositMoney(Customer customer, Double amountOfMoneyToDeposit);
}
