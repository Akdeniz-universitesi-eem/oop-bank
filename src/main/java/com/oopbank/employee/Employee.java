package com.oopbank.employee;

import com.oopbank.generic.money.Money;
import com.oopbank.person.Person;
import com.oopbank.utils.factory.IDBObject;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends Person implements IDBObject {

    private Job job;

    private Money salary;

    @Override
    public void getPromotion(){
        if(job == Job.STANDARTWORKER){
            job = Job.MANAGER;
        }
    }




}
