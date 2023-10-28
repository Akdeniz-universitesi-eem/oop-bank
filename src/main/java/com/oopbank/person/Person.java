package com.oopbank.person;

import lombok.*;

@Getter
@Setter
public abstract class Person {

    private String id;

    private String fullname;

    private String email;

    protected void getPromotion(){

    }

    /*
      public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }
    */

}
