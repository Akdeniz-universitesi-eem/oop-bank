package com.oopbank.bankoffice;

import com.oopbank.account.BankAccount;
import com.oopbank.service.money.IMoneyDrawable;
import com.oopbank.service.money.MoneyOperationsService;
import com.oopbank.customer.Customer;
import com.oopbank.employee.Employee;
import com.oopbank.generic.money.Money;
import com.oopbank.utils.factory.IDBObject;
import lombok.*;

import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankOffice implements IMoneyDrawable, IDBObject {

    private String id;

    private String name;

    private String location;

    private Money depositedMoneyInBank;

    private ArrayList<Employee> workers;

    private ArrayList<BankAccount> customerAccounts;


    @Override
    public void withdrawMoney(Customer customer, Double amountOfMoneyToWithdraw) {
        MoneyOperationsService.withdrawMoney(this, customer, amountOfMoneyToWithdraw);
    }

    @Override
    public void depositMoney(Customer customer, Double amountOfMoneyToDeposit) {
        MoneyOperationsService.depositMoney(this, customer, amountOfMoneyToDeposit);
    }


}
