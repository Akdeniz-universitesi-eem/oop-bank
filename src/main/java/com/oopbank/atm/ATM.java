package com.oopbank.atm;

import com.oopbank.customer.Customer;
import com.oopbank.generic.money.Money;
import lombok.*;

import java.util.Currency;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATM implements IMoneyDrawable {

    private static Double LIMITS_OF_ATM = 20000.0;

    private String id;

    private String location;

    private Money moneyInATM;

    @Override
    public void withdrawMoney(Customer customer,Double amounttowithdraw){
        if(amounttowithdraw > moneyInATM.getAmount()){
            System.out.println("ATM BAKIYESI YETERSIZ");
        } else if(amounttowithdraw > customer.getDepositedMoney().getAmount()){
            System.out.println("KULLANICI BAKIYESI YETERSIZ");
        }
        Double balancediffForCustomer = customer.getDepositedMoney().getAmount() - amounttowithdraw;
        customer.setDepositedMoney(new Money(balancediffForCustomer, customer.getDepositedMoney().getCurrency()));

        Double balancediffForATM = moneyInATM.getAmount() - amounttowithdraw;
        this.setMoneyInATM(new Money(balancediffForATM, moneyInATM.getCurrency()));
    }

    //TODO: deposit money methodunu yazınız
    @Override
    public void depositMoney(Customer customer, Double amountOfMoneyToDeposit) {

    }



}
