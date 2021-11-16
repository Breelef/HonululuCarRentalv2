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
    public static void changeCompany(ArrayList<Private> list) throws IOException {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++){
            System.out.println("Nr. "+(i+1)+"\n"+list.get(i));
        }
        System.out.print("Enter the number of the Company customer you want to edit: ");
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
                System.out.print("Enter new name: ");
                tempObject.name = scan.nextLine();
                break;
            case 2:
                System.out.print("Enter new address: ");
                tempObject.address = scan.nextLine();
                break;
            case 3:
                System.out.print("Enter new postal code: ");
                tempObject.postNr = scan.nextInt();
                break;
            case 4:
                System.out.print("Enter new city: ");
                tempObject.city = scan.nextLine();
                break;
            case 5:
                System.out.print("Enter new mobile phone number: ");
                tempObject.mobilePhone = scan.nextInt();
                break;
            case 6:
                System.out.print("Enter new phone number: ");
                tempObject.phone = scan.nextInt();
                break;
            case 7:
                System.out.print("Enter new e-mail: ");
                tempObject.email = scan.nextLine();
                break;
            case 8:
                System.out.print("Enter new License plate: ");
                tempObject.licenseNr = scan.next();
                break;
            case 9:
                System.out.print("Enter new date for driver license acquired: ");
                tempObject.driverDate = scan.nextLine();
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
    //Add company customer method
    public static void addCompany(ArrayList<Company> companyList) throws IOException{      //IDE: skriv det i customer og så kun hav det ekstra her
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
        //Skriver til fil
        FileWriter fileWriter = new FileWriter("companyCustomer", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(companyAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        companyList.add(companyAdd);
        System.out.println("Vil du se oversigt over kunderne?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("ja")){
            for (int i = 0; i < companyList.size(); i++) {
                System.out.println(companyList.get(i));
            }
        }
    }
   public static void addToArrays(ArrayList<Company> companyList) throws IOException {
        FileReader fr = new FileReader("companyCustomer");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String fName = "";
        String adress = "";
        int postalCode = 0;
        String city = "";
        int mPhone = 0;
        int phone = 0;
        String email = "";
        String cName = "";
        String cAdress = "";
        int cNumber = 0;
        int cRegNr = 0;
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
            if (line.contains("Company name")) {
                cName = line.split(":")[1].trim();
            }
            if (line.contains("Company address")) {
                cAdress = line.split(":")[1].trim();
            }
            if (line.contains("Company phone number")) {
                useMe = line.split(":")[1].trim();
                cNumber = Integer.parseInt(useMe);
            }
            if (line.contains("Company registration number")) {
                useMe = line.split(":")[1].trim();
                cRegNr = Integer.parseInt(useMe);
            }
            if(line.contains("*********************************")){
                Company companyAdd = new Company(fName, adress, postalCode, city, mPhone, phone, email,
                        cName, cAdress, cNumber, cRegNr);
                companyList.add(companyAdd);
            }
        }
        br.close();
        fr.close();
    }

    @Override
    public String toString() {
        return ("Name: " + name + "\nAddress: " + address + "\nPostal code: " + postNr + "\nCity: " + city +
                "\nMobile phone number: " + mobilePhone + "\nPhone number: " + phone + "\nE-mail: " + email +
                "\nCompany name: " + companyName + "\nCompany address: " + companyAddress +
                "\nCompany phone number: " + companyNr + "\nCompany registration number: " + companyRegNr+"\n*********************************");
    }
}
