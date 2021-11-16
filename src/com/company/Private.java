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
    public void addPrivate(ArrayList<Private> privateList) throws IOException{  //IDE: skriv det i customer og så kun hav det ekstra her
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
        System.out.println("Vil du se oversigt over kunderne?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("ja")){
            for (int i = 0; i < privateList.size(); i++) {
                System.out.println(privateList.get(i));
            }
        }
    }
    public static void addToArrays(ArrayList<Private> privateList) throws IOException {
        privateList.clear();
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
    }
    public void changePrivate(ArrayList<Private> list) throws IOException {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++){
            System.out.println("Nr. "+(i+1)+"\n"+list.get(i));
        }
        System.out.print("Enter the number of the Private customer you want to edit: ");
        int changeNumber = scan.nextInt();
        System.out.println();
        Private tempObject = list.get((changeNumber-1));
        String changeList = tempObject.toString();

        String showNumbersList = changeList
                .replace("Name", "1 - Name")
                .replace("Address", "2 - Address")
                .replace("Postal code", "3 - Postal code")
                .replace("City", "4 - City")
                .replace("Mobile phone number", "5 - Mobile phone number")
                .replace("Phone number", "6 - Phone number")
                .replace("E-mail", "7 - E-mail")
                .replace("License plate", "8 - License plate")
                .replace("Driver license acquired", "9 - Driver license acquired")
                .replace("*********************************", "");
        System.out.print("Private customer nr. " + changeNumber + ":\n\n" + showNumbersList);

        System.out.print("Enter the number of the information you want to edit: ");
        int infoNumber = scan.nextInt();
        scan.nextLine();       //Stops the next line from getting "eaten"
        System.out.println();

        switch (infoNumber) {
            case 1:
                System.out.print("Enter new name: ");   //Lav alle om til denne måde!!! så spare vi plads :-)
                tempObject.name = scan.nextLine();
                break;
            case 2:
                System.out.print("Enter new address: ");
                scan.nextLine();       //Stops the next line from getting "eaten"
                String newA = scan.nextLine();
                tempObject.address = newA;
                break;
            case 3:
                System.out.print("Enter new postal code: ");
                int newPC = scan.nextInt();
                tempObject.postNr = newPC;
                break;
            case 4:
                System.out.print("Enter new city: ");
                scan.nextLine();       //Stops the next line from getting "eaten"
                String newC = scan.nextLine();
                tempObject.city = newC;
                break;
            case 5:
                System.out.print("Enter new mobile phone number: ");
                int newMPN = scan.nextInt();
                tempObject.mobilePhone = newMPN;
                break;
            case 6:
                System.out.print("Enter new phone number: ");
                int newPN = scan.nextInt();
                tempObject.phone = newPN;
                break;
            case 7:
                System.out.print("Enter new e-mail: ");
                scan.nextLine();       //Stops the next line from getting "eaten"
                String newE = scan.nextLine();
                tempObject.email = newE;
                break;
            case 8:
                System.out.print("Enter new License plate: ");
                String newL = scan.next();
                tempObject.licenseNr = newL;
                break;
            case 9:
                System.out.print("Enter new date for driver license acquired: ");
                scan.nextLine();       //Stops the next line from getting "eaten"
                String newD = scan.nextLine();
                tempObject.driverDate = newD;
                break;
            default:
                System.out.println("Number " + infoNumber + " is not not a valid option");
                break;
        }

        System.out.println("\nPrivate customer nr. "+changeNumber+" with the edit: ");
        list.set((changeNumber-1), tempObject);
        System.out.println(list.get(changeNumber-1));

        //Prints the updated ArrayList to the file
        FileWriter writer = new FileWriter("privateCustomer");
        for(Private p: list) {
            writer.write(p + System.lineSeparator());
        }
        writer.close();
    }
    @Override
    public String toString() {
        return ("Name: " +name+ "\nAddress: "+address+ "\nPostal code: "+postNr+ "\nCity: "+city+
                "\nMobile phone number: "+mobilePhone +"\nPhone number: "+phone +"\nE-mail: "+email+
                "\nLicense plate: "+licenseNr+ "\nDriver license acquired: "+driverDate+"\n*********************************");
    }
}
