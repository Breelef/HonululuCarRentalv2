package com.company;

public class Company extends Customer {
    String companyName;
    String companyAddress;
    int companyNr;
    int companyRegNr;

    public Company(String name, String address, int postNr, String city, int mobilePhone, int phone, String email,
                   String companyName, String companyAddress, int companyNr, int companyRegNr) {
        super(name, address, postNr, city, mobilePhone, phone, email);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyNr = companyNr;
        this.companyRegNr = companyRegNr;
    }

    public Company() {

    }

    @Override
    public String toString() {
        return ("Name: " + name + "\nAddress: " + address + "\nPostal code: " + postNr + "\nCity: " + city +
                "\nMobile phone number: " + mobilePhone + "\nPhone number: " + phone + "\nE-mail: " + email +
                "\nCompany name: " + companyName + "\nCompany address: " + companyAddress +
                "\nCompany phone number: " + companyNr + "\nCompany registration number: " + companyRegNr);
    }
}
