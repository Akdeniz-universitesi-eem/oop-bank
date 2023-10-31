package com.oopbank.atm;

import com.oopbank.customer.Customer;
import com.oopbank.employee.Employee;
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

    private ArrayList<Employee> workers;

    @Override
    public void withdrawMoney(Customer customer, Double amountOfMoneyToWithdraw) {

    }

    @Override
    public void depositMoney(Customer customer, Double amountOfMoneyToDeposit) {

    }
}
