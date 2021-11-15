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

        //boolean gear: true = manuel gear, false = automat gear
        Sport audi = new Sport("Audi", "R8", "Diesel", 2123122, 2021, 7, 29000, true,550);
        Family vw = new Family("Volkswagen", "Golf", "Benzin", 44221231, 2021, 9, 33000, true, true, false, 5);
        Luxury rr = new Luxury("Rolls-Royce", "Phantom VIII", "Benzin", 31231232, 2020, 2, 19000, 3230, false, true, true, "Lædersæder");
        //System.out.println(audi);
        //System.out.println(vw);
        //System.out.println(rr);
        //System.out.println();

        //Test for the Customer class
        Company tdc = new Company("Per", "Nørrebrogade 4", 2200,"København", 11221122,
                22332233, "Per@TDC.dk", "TDC", "Øserbrogade 5", 99999999, 10150814 );

        Private erik = new Private("Per", "Nørrebrogade 4", 2200,"København", 11221122, 22332233,
                "Per@TDC.dk", "MD98343", "09/10/1998");
        companyList.add(tdc);
        privateList.add(erik);
        //Sport.addToArrays(sportList);
        Luxury.addToArrays(luxuryList);
        //Main menu
        int menuAnswer = -1;
        while(menuAnswer != 0){
            System.out.println("*************************\nHonululu Car Rental menu:\n");
            System.out.println("""
                   Enter 0 to exit program
                   Enter 1 to show active rentals
                   Enter 2 to show company customers
                   Enter 3 to add a new customer""");
            System.out.println("Enter 5 to add car to inventory");
            menuAnswer = input.nextInt();
            if (menuAnswer > 7){
                System.out.println(menuAnswer+" is not a legal answer");
            }else {
                switch (menuAnswer) {
                    case 1:

                        break;
                    case 2:
                        System.out.println(companyList);
                        break;
                    case 3:
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
                    case 4:
                        System.out.println("""
                               Enter 1 to add a company customer
                               Enter 2 to add a private customer""");
                        customerAnswer = input.nextInt();
                        if(customerAnswer == 1){
                            Company.addToArrays(companyList);
                        }else if(customerAnswer == 2){
                            Private.addToArrays(privateList);
                        }else {
                            System.out.println(customerAnswer + " is not a legal answer");
                        }
                        break;
                    case 5:
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
                    default:
                        System.out.println("BuFu");
                        break;
                }
            }
        }
    }
}
//pølse