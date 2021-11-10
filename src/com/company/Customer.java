package com.company;

public class Customer {
    String name;
    String address;
    int postNr;
    String city;
    int mobilePhone;
    int phone;
    String email;

    public Customer(String name, String address, int postNr, String city, int mobilePhone, int phone, String email){
        this.name = name;
        this.address = address;
        this.postNr = postNr;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
    }
    public Customer(){

    }
    public String toString() {
        return ("Name: " +name+ "\nAddress: "+address+ "\nPostal code: "+postNr+ "\nCity: "+city+
                "\nMobile phone number: "+mobilePhone +"\nPhone number: "+phone +"\nE-mail: "+email);
    }

}
