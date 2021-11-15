package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Private extends Customer {
    String licenseNr;
    String driverDate;

    public Private(String name, String address, int postNr, String city, int mobilePhone, int phone, String email,
                   String licenseNr, String driverDate){
        super(name, address, postNr,  city, mobilePhone, phone, email);
        this.licenseNr = licenseNr;
        this.driverDate = driverDate;
    }
    public Private(){

    }
    public static void addPrivate(ArrayList<Private> privateList){  //IDE: skriv det i customer og så kun hav det ekstra her
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        String nameT = input.nextLine();
        System.out.println("Enter address: ");
        String addressT = input.nextLine();
        System.out.println("Enter postal code: ");
        int postNrT = input.nextInt();
        input.nextLine();       //Stops the next line from getting "eaten"
        System.out.println("Enter city: ");
        String cityT = input.nextLine();
        System.out.println("Enter mobile number: ");
        int mobilePhoneT = input.nextInt();
        System.out.println("Enter phone number: ");
        int phoneT = input.nextInt();
        System.out.println("Enter email: ");
        String emailT = input.next();
        System.out.println("Enter the drivers license number: ");
        String licenseNrT = input.next();
        System.out.println("Enter the date that you acquired drivers license");
        String driverDateT = input.next();

        Private privateAdd = new Private(nameT, addressT, postNrT, cityT, mobilePhoneT, phoneT, emailT, licenseNrT, driverDateT);
        privateList.add(privateAdd);
    }
    @Override
    public String toString() {
        return ("Name: " +name+ "\nAddress: "+address+ "\nPostal code: "+postNr+ "\nCity: "+city+
                "\nMobile phone number: "+mobilePhone +"\nPhone number: "+phone +"\nE-mail: "+email+
                "\nLicense plate: "+licenseNr+ "\nDriver license acquired: "+driverDate);
    }
}
