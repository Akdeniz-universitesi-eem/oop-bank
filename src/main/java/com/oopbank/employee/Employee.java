package com.oopbank.employee;

import com.oopbank.person.Person;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends Person {

    private Job job;

    @Override
    public void getPromotion(){
        if(job == Job.STANDARTWORKER){
            job = Job.MANAGER;
        }
    }
}
