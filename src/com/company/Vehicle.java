package com.company;
import java.util.*;
import java.io.*;

public class Vehicle {
    String brand;
    String model;
    String fuel;
    int regNr;
    int regYear;
    int regMonth;
    int odoMeter;

    public Vehicle(String b, String m, String f, int nr, int year, int month, int om){
        brand = b;
        model = m;
        fuel = f;
        regNr = nr;
        regYear = year;
        regMonth = month;
        odoMeter = om;
    }
    public Vehicle(){
    }
    public static void printArrays (Scanner input, ArrayList<Luxury> luxuryList, ArrayList<Sport> sportList, ArrayList<Family> familyList) {
        System.out.println("Which list would you like to print?");
        System.out.println("Press 1 for luxury cars");
        System.out.println("Press 2 for sport cars");
        System.out.println("Press 3 for family cars");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                for (int i = 0; i < luxuryList.size(); i++) {
                    System.out.println(luxuryList.get(i));
                }
                break;
            case 2:
                for (int i = 0; i < sportList.size(); i++) {
                    System.out.println(sportList.get(i));
                }
                break;
            case 3:
                for (int i = 0; i < familyList.size(); i++) {
                    System.out.println(familyList.get(i));
                    break;
                }
            default:
                System.out.println("No list to print");
                break;
        }
    }

    public String toString(){
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nRegistreringsnummer: "
                +regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"km");
    }
}