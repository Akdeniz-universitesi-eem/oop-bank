package com.oopbank.service.money;

import com.oopbank.customer.Customer;

public interface IMoneyDrawable {

    void withdrawMoney(Customer customer, Double amountOfMoneyToWithdraw);

    void depositMoney(Customer customer, Double amountOfMoneyToDeposit);
}
