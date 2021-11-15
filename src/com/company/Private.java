package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
    public static void addPrivate(ArrayList<Private> privateList) throws IOException{  //IDE: skriv det i customer og så kun hav det ekstra her
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
        //Skriver til fil
        FileWriter fileWriter = new FileWriter("privateCustomer", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(privateAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        privateList.add(privateAdd);
    }
    public static void addToArrays(ArrayList<Private> privateList) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\emil_\\datamatiker\\Honululu car rental v2\\privateCustomer");
        BufferedReader br = new BufferedReader(fr);
            String useMe = "";
            String fName = "";
            String adress = "";
            int postalCode = 0;
            String city = "";
            int mPhone = 0;
            int phone = 0;
            String email = "";
            String plate = "";
            String date = "";
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Name")) {
                    fName = line.split(":")[1].trim();
                }
                if (line.contains("Address")) {
                    adress = line.split(":")[1].trim();
                }
                if (line.contains("Postal code")) {
                    useMe = line.split(":")[1].trim();
                    postalCode = Integer.parseInt(useMe);
                }
                if (line.contains("City")) {
                    city = line.split(":")[1].trim();
                }
                if (line.contains("Mobile phone number")) {
                    useMe = line.split(":")[1].trim();
                    mPhone = Integer.parseInt(useMe);
                }
                if (line.contains("Phone number")) {
                    useMe = line.split(":")[1].trim();
                    phone = Integer.parseInt(useMe);
                }
                if (line.contains("E-mail")) {
                    email = line.split(":")[1].trim();
                }
                if (line.contains("License plate")) {
                    plate = line.split(":")[1].trim();
                }
                if (line.contains("Driver license acquired")) {
                    date = line.split(":")[1].trim();
                }
                if(line.contains("*********************************")){
                    Private privateAdd = new Private(fName, adress, postalCode, city, mPhone, phone, email, plate, date);
                    privateList.add(privateAdd);
            }
        }
        br.close();
        fr.close();
        System.out.println(privateList);
    }

    @Override
    public String toString() {
        return ("Name: " +name+ "\nAddress: "+address+ "\nPostal code: "+postNr+ "\nCity: "+city+
                "\nMobile phone number: "+mobilePhone +"\nPhone number: "+phone +"\nE-mail: "+email+
                "\nLicense plate: "+licenseNr+ "\nDriver license acquired: "+driverDate+"\n*********************************");
    }
}
