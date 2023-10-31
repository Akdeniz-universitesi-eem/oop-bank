package com.oopbank.atm;

import com.oopbank.customer.Customer;
import com.oopbank.generic.money.Money;
import com.oopbank.utils.factory.IDBObject;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATM implements IMoneyDrawable, IDBObject {

    private static Double LIMITS_OF_ATM = 20000.0;

    private String id;

    private String location;

    private Money moneyInATM;

    @Override
    public void withdrawMoney(Customer customer,Double amounttowithdraw){
        if(amounttowithdraw > moneyInATM.getAmount()){
            System.out.println("ATM BAKIYESI YETERSIZ");
        }
        Double newCustomerBalance = customer.getDepositedMoney().getAmount() + amounttowithdraw;
        customer.setDepositedMoney(new Money(newCustomerBalance, customer.getDepositedMoney().getCurrency()));

        Double newATMBalance = moneyInATM.getAmount() - amounttowithdraw;
        this.setMoneyInATM(new Money(newATMBalance, moneyInATM.getCurrency()));
    }

    //TODO: deposit money methodunu yazınız
    @Override
    public void depositMoney(Customer customer, Double amountOfMoneyToDeposit) {
        if(amountOfMoneyToDeposit < customer.getDepositedMoney().getAmount()){
            System.out.println("KULLANICI BAKIYESI YETERSIZ");
            return;
        }
        Double newCustomerBalance = customer.getDepositedMoney().getAmount() - amountOfMoneyToDeposit;
        customer.setDepositedMoney(new Money(newCustomerBalance, customer.getDepositedMoney().getCurrency()));

        Double newATMBalance = moneyInATM.getAmount() + amountOfMoneyToDeposit;
        this.setMoneyInATM(new Money(newATMBalance, moneyInATM.getCurrency()));
    }



}
