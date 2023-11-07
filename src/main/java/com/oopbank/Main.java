package com.oopbank;


import com.oopbank.account.BankAccount;
import com.oopbank.atm.ATM;
import com.oopbank.bankoffice.BankOffice;
import com.oopbank.bankoffice.BankService;
import com.oopbank.customer.Customer;
import com.oopbank.employee.Employee;
import com.oopbank.utils.db.DB;
import com.oopbank.utils.db.DBUtils;
import com.oopbank.utils.factory.IDBObject;
import com.oopbank.utils.generic.PrinterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static DB db ;
    private static List<Customer> customers;
    private static List<Employee>employees;
    private static List<ATM> atms;
    private static List<BankOffice> bankOffices;

    public static void main(String[] args) {
        init();

        PrinterUtils.printOutAllATMs(atms);
        PrinterUtils.printOutAllBankOffices(bankOffices);
        PrinterUtils.printOutAllEmployees(employees);
        PrinterUtils.printOutAllCustomers(customers);

        BankService bankService = new BankService(bankOffices.get(0));
        bankService.getAllBankAccounts().stream().forEach(account -> {
            System.out.println("CUSTOMER ID : " + account.getAccountownerid());
        });

        ATM atm1 = atms.get(0);
        ATM atm2 = atms.get(1);
        atm1.atmApp(customers.get(0));
        atm2.atmApp(customers.get(0));
    }

    private static void init(){
        db = DB.getInstance();
        customers = db.getTable(Customer.class).getRows().stream().toList();
        employees = db.getTable(Employee.class).getRows().stream().toList();
        atms = db.getTable(ATM.class).getRows().stream().toList();
        bankOffices = db.getTable(BankOffice.class).getRows().stream().toList();
    }


}