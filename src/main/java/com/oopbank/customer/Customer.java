package com.oopbank.customer;

import com.oopbank.employee.Employee;
import com.oopbank.generic.money.Money;
import com.oopbank.person.Person;
import com.oopbank.utils.factory.IDBObject;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends Person implements IDBObject {

    private Money depositedMoney;

    @Override
    public void getPromotion(){
        Double tempbalance = depositedMoney.getAmount();
        depositedMoney.setAmount(tempbalance + 1000);
    }


}
