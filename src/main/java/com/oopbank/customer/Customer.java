package com.oopbank.customer;

import com.oopbank.generic.money.Money;
import com.oopbank.person.Person;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends Person {

    private Money depositedMoney;

    @Override
    public void getPromotion(){
        Double tempbalance = depositedMoney.getAmount();
        depositedMoney.setAmount(tempbalance + 1000);
    }

}
