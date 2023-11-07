package com.oopbank.utils.factory;

import com.oopbank.account.BankAccount;
import com.oopbank.atm.ATM;
import com.oopbank.bankoffice.BankOffice;
import com.oopbank.card.BankCard;
import com.oopbank.customer.Customer;
import com.oopbank.employee.Employee;
import com.oopbank.employee.Job;
import com.oopbank.generic.money.Currency;
import com.oopbank.generic.money.Money;
import com.oopbank.utils.generic.RandomizerUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class BaseFactory {

    public Customer generateCustomerDBObject(BankOffice bankOffice) {
        Customer customer = new Customer();
        customer.setId(RandomizerUtils.getRandomAlphaNumeric());
        customer.setFullname(RandomizerUtils.getRandomAlphaNumeric());
        customer.setEmail(RandomizerUtils.getRandomEmail(12));
        customer.setDepositedMoney(new Money(1000.0, Currency.TRY));

        String randomCardNo = RandomizerUtils.getRandomAlphaNumeric(16);
        String randomCvcNo = RandomizerUtils.getRandomAlphaNumeric(3);
        customer.setBankCard(new BankCard(randomCardNo, customer.getFullname(), new Date(2025, Calendar.DECEMBER, 1), randomCvcNo));
        customer.setBankAccount(new BankAccount(customer.getId(), customer.getFullname(), bankOffice.getId()));

        if(bankOffice.getCustomerAccounts() == null){
            ArrayList<BankAccount> customerAccounts = new ArrayList<>();
            customerAccounts.add(customer.getBankAccount());
            bankOffice.setCustomerAccounts(customerAccounts);
        }
        bankOffice.getCustomerAccounts().add(customer.getBankAccount());

        return customer;
    }

    public Employee generateStandartEmployeeDBObject(BankOffice bankOffice) {
        Employee employee = new Employee();
        employee.setId(RandomizerUtils.getRandomAlphaNumeric());
        employee.setJob(Job.STANDARTWORKER);
        employee.setEmail(RandomizerUtils.getRandomEmail(12));
        employee.setFullname(RandomizerUtils.getRandomAlphaNumeric());
        employee.setSalary(new Money(40000.0, Currency.TRY));
        if(bankOffice.getWorkers() == null){
            ArrayList<Employee> employees = new ArrayList<>();
            employees.add(employee);
            bankOffice.setWorkers(employees);
        }
        bankOffice.getWorkers().add(employee);
        return employee;
    }

    public Employee generateManagerEmployeeDBObject(BankOffice bankOffice) {
        Employee employee = new Employee();
        employee.setId(RandomizerUtils.getRandomAlphaNumeric());
        employee.setJob(Job.MANAGER);
        employee.setEmail(RandomizerUtils.getRandomEmail(12));
        employee.setFullname(RandomizerUtils.getRandomAlphaNumeric());
        employee.setSalary(new Money(70000.0, Currency.TRY));
        if(bankOffice.getWorkers() == null){
            ArrayList<Employee> employees = new ArrayList<>();
            employees.add(employee);
            bankOffice.setWorkers(employees);
        }
        bankOffice.getWorkers().add(employee);
        return employee;
    }


    public ATM generateATMDBObject() {
         ATM atm = new ATM();
         atm.setId(RandomizerUtils.getRandomAlphaNumeric());
         atm.setLocation(RandomizerUtils.getRandomAlphaNumeric(20));
         atm.setMoneyInATM(new Money(10_000.0, Currency.TRY));
         return atm;
    }



    public BankOffice generateBankOfficeDBObject() {
        BankOffice bankOffice = new BankOffice();
        bankOffice.setId(RandomizerUtils.getRandomAlphaNumeric());
        bankOffice.setName(RandomizerUtils.getRandomAlphaNumeric());
        bankOffice.setLocation(RandomizerUtils.getRandomAlphaNumeric());
        bankOffice.setDepositedMoneyInBank(new Money(1_000_000.0, Currency.TRY));
        return bankOffice;
    }


}
