package com.oopbank.atm;

import com.oopbank.customer.Customer;
import com.oopbank.generic.money.Money;
import com.oopbank.service.money.IMoneyDrawable;
import com.oopbank.service.money.MoneyOperationsService;
import com.oopbank.utils.factory.IDBObject;
import lombok.*;

import java.util.ArrayList;
import java.util.Scanner;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATM implements IMoneyDrawable, IDBObject {

    private String id;

    private String location;

    private Money moneyInATM;

    private Customer customerInUse;


    public void atmApp(Customer customer){
        this.customerInUse = customer;
        printMenu();
    }

    private void atmOperation(ATMOperations operation, Double amount){
        if(operation == operation.ACCOUNTINFO){
            printAccountBalance(customerInUse);
        }else if(operation == operation.WITHDRAW){
            withdrawMoney(customerInUse, amount);
        } else if (operation == ATMOperations.DEPOSIT) {
            depositMoney(customerInUse, amount);
        }
    }

    private void printMenu(){
        Scanner kb = new Scanner(System.in);

        while (true){
            System.out.println("ATM " + this.getId()
                    + "     KONUM : " + this.getLocation());

            System.out.println("1) Bakiye Sorgulama\n" +
                    "2)Para Çekme\n" +
                    "3)Para Yatırma\n" +
                    "4)Çıkış");

            int userOperationInput = Integer.parseInt(kb.nextLine());

            //INFO
            if(userOperationInput == 1){
                atmOperation(ATMOperations.ACCOUNTINFO, null);
            }
            //WITHDRAW FROM ATM
            else if (userOperationInput == 2) {
                System.out.println(
                        "Bakiyeniz : " + customerInUse.getDepositedMoney().getAmount() + customerInUse.getDepositedMoney().getCurrency()
                        + "\nTutar giriniz : " );
                Double amount = Double.parseDouble(kb.nextLine());
                atmOperation(ATMOperations.WITHDRAW, amount);
            }
            //DEPOSIT TO ATM
            else if (userOperationInput == 3) {
                System.out.println(
                        "Bakiyeniz : " + customerInUse.getDepositedMoney().getAmount() + customerInUse.getDepositedMoney().getCurrency()
                        + "\nTutar giriniz : " );
                Double amount = Double.parseDouble(kb.nextLine());
                atmOperation(ATMOperations.DEPOSIT, amount);
            }
            //EXIT
            else {
                return;
            }
        }
    }

    private void printAccountBalance(Customer customer){
        System.out.println("Merhaba, " + customer.getFullname()
                        + "     Bakiyeniz : " + customer.getDepositedMoney().getAmount() + customer.getDepositedMoney().getCurrency());
    }

    @Override
    public void withdrawMoney(Customer customer, Double amountOfMoneyToWithdraw) {
        MoneyOperationsService.withdrawMoney(this, customer, amountOfMoneyToWithdraw);
    }

    @Override
    public void depositMoney(Customer customer, Double amountOfMoneyToDeposit) {
        MoneyOperationsService.depositMoney(this, customer, amountOfMoneyToDeposit);
    }
}
