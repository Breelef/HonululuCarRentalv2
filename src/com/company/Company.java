package com.company;
import java.io.*;
import java.util.*;

public class Company extends Customer {
    String companyName;
    String companyAddress;
    int companyNr;
    int companyRegNr;

    public Company(String name, String address, int postNr, String city, int mobilePhone, int phone, String email,
                   String companyName, String companyAddress, int companyNr, int companyRegNr)  {
        super(name, address, postNr, city, mobilePhone, phone, email);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyNr = companyNr;
        this.companyRegNr = companyRegNr;
    }
    public Company() {

    }
    //Add company customer method
    public static void addCompany(ArrayList<Company> companyList){      //IDE: skriv det i customer og så kun hav det ekstra her
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
        System.out.println("Enter company name: ");
        String companyNameT = input.nextLine();
        input.nextLine();       //Stops the next line from getting "eaten"
        System.out.println("Enter company address: ");
        String companyAddressT = input.nextLine();
        System.out.println("Enter company phone number: ");
        int companyNrT = input.nextInt();
        System.out.println("Enter company registration number: ");
        int companyRegNrT = input.nextInt();

        Company companyAdd = new Company(nameT, addressT, postNrT, cityT, mobilePhoneT, phoneT, emailT,
                                            companyNameT, companyAddressT, companyNrT, companyRegNrT);
        companyList.add(companyAdd);

    }

    public void writeCompanyToFile(ArrayList<Company> list)throws FileNotFoundException{
        Scanner input = new Scanner(new File("Recourses/companyCustomer"));
        while(input.hasNextLine()){
        }
    }

    @Override
    public String toString() {
        return ("Name: " + name + "\nAddress: " + address + "\nPostal code: " + postNr + "\nCity: " + city +
                "\nMobile phone number: " + mobilePhone + "\nPhone number: " + phone + "\nE-mail: " + email +
                "\nCompany name: " + companyName + "\nCompany address: " + companyAddress +
                "\nCompany phone number: " + companyNr + "\nCompany registration number: " + companyRegNr);
    }
}
