package com.practice.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drink extends Product {

    private int capacity;

    public Drink(String name,int price , int capacity){
        super(name,price);
        this.capacity=capacity;
    }

    public String toString(){
        return super.toString() + capacity;
    }
}
