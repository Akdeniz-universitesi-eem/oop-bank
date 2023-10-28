package com.oopbank.generic.money;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Money {

    private Double amount;

    private Currency currency;
}
