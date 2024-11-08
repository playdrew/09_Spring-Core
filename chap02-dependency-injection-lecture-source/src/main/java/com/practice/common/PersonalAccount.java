package com.practice.common;

public class PersonalAccount implements Account{

    private final int bankCode;
    private final String bankAccount;
    private int balance;

    public PersonalAccount(int bankCode,String bankAccount){
        this.bankCode=bankCode;
        this.bankAccount=bankAccount;
    }

    @Override
    public String balance() {
        return this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        if(money>0){
            balance +=money;
        }else{
            System.out.println("예금할 수 없는 금액입니다.");
        }
        return money + "원 만큼 예금하셨습니다";
    }

    @Override
    public String withdraw(int money) {
        if(money<balance){
            balance+=money;
        }else{
            System.out.println("인출할수 없는 금액입니다");
        }
        return money + "원 만큼 인출하였습니다.";
    }
}
