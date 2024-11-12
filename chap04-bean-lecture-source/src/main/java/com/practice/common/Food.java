package com.practice.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Food extends Product {

    private Date bakedDate;

    public Food(String name,int price,Date bakedDate){
        super(name,price);
        this.bakedDate=bakedDate;
    }

    public String toString(){
        return super.toString() + bakedDate;
    }

}
