package com.oopbank.customer;

import com.oopbank.account.BankAccount;
import com.oopbank.card.BankCard;
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

    private BankAccount bankAccount;

    private BankCard bankCard;
}
