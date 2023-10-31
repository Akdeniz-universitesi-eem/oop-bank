package com.oopbank.utils.db;

import com.oopbank.atm.ATM;
import com.oopbank.atm.BankOffice;
import com.oopbank.customer.Customer;
import com.oopbank.employee.Employee;
import com.oopbank.utils.factory.BaseFactory;
import com.oopbank.utils.factory.IDBObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DB {

    private Map<Class, DBTable<?>> tables;
    private static DB INSTANCE;

    private BaseFactory factory;

    private DB(){
        init();
    }

    public static DB getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DB();
        }
        return INSTANCE;
    }

    public <T extends IDBObject> DBTable<T> insertIntoDB(Class<T> clazz, DBTable<T> incomingTable){
        DBTable<T> tableInDB = getTable(clazz);
        if(tableInDB != null){
            incomingTable.getRows().forEach(tableInDB::addRow);
            return tableInDB;
        }
        tables.put(clazz, incomingTable);
        return getTable(clazz);
    }
    public <T extends IDBObject> DBTable<T> getTable(Class<T> clazz){
        return (DBTable<T>) tables.get(clazz);
    }

    public static <T extends IDBObject> List<T> getRows(Class<T> clazz) {
        return DB.getInstance().getTable(clazz).getRows();
    }

    private void init() {
        tables = new HashMap<>();
        insertTablesIntoDB();
    }

    private void insertTablesIntoDB() {
        this.factory = new BaseFactory();
        insertCustomerDBTable();
        insertEmployeeDBTable();
        insertATMDBTable();
        insertBankOfficeDBTable();
    }


    private void insertCustomerDBTable() {
        int objCount = 5;
        DBTable<Customer> customerDBTable = this.insertIntoDB(Customer.class, new DBTable<Customer>());
        for(int i = 0; i < objCount; i++){
            customerDBTable.addRow(factory.generateCustomerDBObject());
        }
        tables.put(Customer.class, customerDBTable);
    }

    private void insertEmployeeDBTable() {
        int objCount = 5;
        DBTable<Employee> employeeDBTable = this.insertIntoDB(Employee.class, new DBTable<Employee>());
        for(int i = 0; i < objCount; i++){
            employeeDBTable.addRow(factory.generateStandartEmployeeDBObject());
            employeeDBTable.addRow(factory.generateManagerEmployeeDBObject());
        }
        tables.put(Employee.class, employeeDBTable);
    }

    private void insertATMDBTable() {
        int objCount = 5;
        DBTable<ATM> atmDBTable = this.insertIntoDB(ATM.class, new DBTable<ATM>());
        for(int i = 0; i < objCount; i++){
            atmDBTable.addRow(factory.generateATMDBObject());
        }
        tables.put(ATM.class, atmDBTable);
    }

    private void insertBankOfficeDBTable() {
        ArrayList<Employee> employees = tables.get(Employee.class).getRows().stream().map(employee -> (Employee) employee).collect(Collectors.toCollection(ArrayList::new));
        DBTable<BankOffice> bankOfficeDBTable = this.insertIntoDB(BankOffice.class, new DBTable<BankOffice>());
        bankOfficeDBTable.addRow(factory.generateBankOfficeDBObject(employees));
        tables.put(BankOffice.class, bankOfficeDBTable);
    }

}
