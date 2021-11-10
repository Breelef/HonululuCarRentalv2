package com.company;

public class Private extends Customer {
    int licensePlate;
    String driverDate;

    public Private(String name, String address, int postNr, String city, int mobilePhone, int phone, String email,
                   int licensePlate, String driverDate){
        super(name, address, postNr,  city, mobilePhone, phone, email);
        this.licensePlate = licensePlate;
        this.driverDate = driverDate;
    }
    public Private(){

    }
    @Override
    public String toString() {
        return ("Name: " +name+ "\nAddress: "+address+ "\nPostal code: "+postNr+ "\nCity: "+city+
                "\nMobile phone number: "+mobilePhone +"\nPhone number: "+phone +"\nE-mail: "+email+
                "\nLicense plate: "+licensePlate+ "\nDriver license acquired: "+driverDate);
    }
}
