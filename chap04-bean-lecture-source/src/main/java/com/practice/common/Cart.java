package com.practice.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {

    private List<Product> productList;

    public Cart(){
        productList=new ArrayList<>();
    }

    public List<Product> printProductList(){
        return productList;
    }

    public void addItem(Product item){
        productList.add(item);
    }
}
