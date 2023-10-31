package com.oopbank.utils.factory;

import com.oopbank.atm.ATM;
import com.oopbank.atm.BankOffice;
import com.oopbank.customer.Customer;
import com.oopbank.employee.Employee;
import com.oopbank.employee.Job;
import com.oopbank.generic.money.Currency;
import com.oopbank.generic.money.Money;
import com.oopbank.utils.db.DBTable;
import com.oopbank.utils.generic.RandomizerUtils;

import java.util.ArrayList;


public class BaseFactory {

    public Customer generateCustomerDBObject() {
        Customer customer = new Customer();
        customer.setId(RandomizerUtils.getRandomAlphaNumeric());
        customer.setFullname(RandomizerUtils.getRandomAlphaNumeric());
        customer.setEmail(RandomizerUtils.getRandomEmail(12));
        customer.setDepositedMoney(new Money(1000.0, Currency.TRY));
        return customer;
    }

    public Employee generateStandartEmployeeDBObject() {
        Employee employee = new Employee();
        employee.setId(RandomizerUtils.getRandomAlphaNumeric());
        employee.setJob(Job.STANDARTWORKER);
        employee.setEmail(RandomizerUtils.getRandomEmail(12));
        employee.setFullname(RandomizerUtils.getRandomAlphaNumeric());
        employee.setSalary(new Money(40000.0, Currency.TRY));
        return employee;
    }

    public Employee generateManagerEmployeeDBObject() {
        Employee employee = new Employee();
        employee.setId(RandomizerUtils.getRandomAlphaNumeric());
        employee.setJob(Job.MANAGER);
        employee.setEmail(RandomizerUtils.getRandomEmail(12));
        employee.setFullname(RandomizerUtils.getRandomAlphaNumeric());
        employee.setSalary(new Money(70000.0, Currency.TRY));
        return employee;
    }


    public ATM generateATMDBObject() {
         ATM atm = new ATM();
         atm.setId(RandomizerUtils.getRandomAlphaNumeric());
         atm.setLocation(RandomizerUtils.getRandomAlphaNumeric(20));
         atm.setMoneyInATM(new Money(100000.0, Currency.TRY));
         return atm;
    }



    public BankOffice generateBankOfficeDBObject(ArrayList<Employee> employees) {
        BankOffice bankOffice = new BankOffice();
        bankOffice.setId(RandomizerUtils.getRandomAlphaNumeric());
        bankOffice.setName(RandomizerUtils.getRandomAlphaNumeric());
        bankOffice.setLocation(RandomizerUtils.getRandomAlphaNumeric());
        bankOffice.setWorkers(employees);
        return bankOffice;
    }


}
