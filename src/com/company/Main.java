package com.company;

import java.awt.print.PrinterAbortException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //ArrayLists
        ArrayList<Company> companyList = new ArrayList<>();
        ArrayList<Private> privateList = new ArrayList<>();
        ArrayList<Luxury> luxuryList = new ArrayList<>();
        ArrayList<Sport> sportList = new ArrayList<>();
        ArrayList<Family> familyList = new ArrayList<>();
        ArrayList<Contracts> contractsList = new ArrayList<>();

        //Reading from files to arrays when program boots
        Sport.addToArrays(sportList);
        Luxury.addToArrays(luxuryList);
        Family.addToArrays(familyList);
        Company.addToArrays(companyList);
        Private.addToArrays(privateList);
        Contracts.addToArrays(contractsList);

        //Main menu
        int menuAnswer = -1;
        while(menuAnswer != 0){
            System.out.println("-------------------------------------\nHonululu Car Rental menu:\n");
            System.out.println("""
                    Enter 0 to exit program
                    Enter 1 to to create a new customer
                    Enter 2 to change customer information
                    Enter 3 to create new car for rental
                    Enter 4 to edit car information
                    Enter 5 to show lists
                    -------------------------------------""");
            menuAnswer = input.nextInt();
            if (menuAnswer > 5){
                System.out.println(menuAnswer+" is not a legal answer");
            }else {
                switch (menuAnswer) {
                    case 1:
                        System.out.println("""
                               Enter 1 to add a company customer
                               Enter 2 to add a private customer""");
                        int customerAnswer = input.nextInt();
                        if (customerAnswer == 1) {
                            Company.addCompany(companyList);
                        } else if (customerAnswer == 2) {
                            Private.addPrivate(privateList);
                        } else {
                            System.out.println(customerAnswer + " is not a legal answer");
                            break;
                        }
                    case 2:

                        break;
                    case 3:
                        int answer = -1;
                        while (answer != 0) {
                            System.out.println("Add new car to inventory");
                            System.out.println("Enter 1 to add familycar!");
                            System.out.println("Enter 2 to add sportscar!");
                            System.out.println("Enter 3 to add luxurycar!");
                            answer = input.nextInt();

                            if (answer > 5) {
                                System.out.println("Not a valid answer!");
                            } else {
                                switch (answer) {
                                    case 1:
                                        Family.addFamily(familyList);
                                        break;
                                    case 2:
                                        Sport.addSport(sportList);
                                        break;
                                    case 3:
                                        Luxury.addLuxury(luxuryList);
                                        break;
                                    default:
                                        System.out.println("Not valid!");
                                }
                            }
                        }
                        break;
                    case 4:

                        break;
                    case 5:
                        int show = -1;
                        show = input.nextInt();
                        switch(show){
                            case 1:
                                Vehicle.printArrays(input, luxuryList,sportList,familyList);
                                break;
                            case 2:
                                Customer.printArrays(input, companyList, privateList);
                                break;
                            case 3:
                                Contracts.printArray(contractsList);
                                break;
                            default:
                                System.out.println("No list to show!");
                                break;
                        }
                        break;
                    default:
                        System.out.println("BuFu");
                        break;
                }
            }
        }
    }
}
