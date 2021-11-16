package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public abstract class Customer {
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
    public static void printArrays (Scanner input, ArrayList<Company> companyList, ArrayList<Private> privateList) {
        System.out.println("Which list would you like to print?");
        System.out.println("Press 1 for company customers");
        System.out.println("Press 2 for private customers");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                for (int i = 0; i < companyList.size(); i++) {
                    System.out.println(companyList.get(i));
                }
                break;
            case 2:
                for (int i = 0; i < privateList.size(); i++) {
                    System.out.println(privateList.get(i));
                }
                break;
            default:
                System.out.println("No list to print");
                break;
        }
    }
    @Override
    public String toString() {
        return ("Name: " +name+ "\nAddress: "+address+ "\nPostal code: "+postNr+ "\nCity: "+city+
                "\nMobile phone number: "+mobilePhone +"\nPhone number: "+phone +"\nE-mail: "+email);
    }
}
