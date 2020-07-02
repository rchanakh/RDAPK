package com.example.rdapp;

public class Retrive {

    private String Name, Amount, AccNo, Mobile, Date;


    public Retrive() {
    }

    public Retrive(String name, String amount, String accNo, String mobile, String date) {
        Name = name;
        Amount = amount;
        AccNo = accNo;
        Mobile = mobile;
        Date = date;

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

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
