package com.example.rdapp;

public class Paid {

    private String Name, Amount, AccNo, Date;
    //private int Month1;

    public Paid() {
    }

    public Paid(String name, String amount, String accNo, String date) {
        Name = name;
        Amount = amount;
        AccNo = accNo;
        Date = date;
        //Month1 = month1;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getAccNo() {
        return AccNo;
    }

    public void setAccNo(String accNo) {
        AccNo = accNo;
    }


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
