package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Family extends Vehicle{
    boolean gear;
    boolean airCondition;
    boolean cruiseControl;
    int seats;

    public Family(String b, String m, String f, int nr, int year, int month, int om, boolean g, boolean ac, boolean cc, int s){
        super(b, m, f, nr, year, month, om);
        gear = g;
        airCondition = ac;
        cruiseControl = cc;
        seats = s;
    }

    public static void addFamily(ArrayList<Family> familyList)throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter brand name: ");
        String b = input.nextLine();
        System.out.println("Enter model name");
        String m = input.nextLine();
        System.out.println("Enter fuel for the car");
        String f = input.nextLine();
        System.out.println("Enter registration number");
        int nr = input.nextInt();
        System.out.println("Enter production year");
        int year = input.nextInt();
        System.out.println("Enter production month");
        int month = input.nextInt();
        System.out.println("Enter Total amount of travel distance of the car");
        int om = input.nextInt();
        System.out.println("Enter true for manuel gear (default for family cars!)");
        boolean g = input.nextBoolean();
        System.out.println("Enter true for AC (default for family cars!)");
        boolean ac = input.nextBoolean();
        System.out.println("Enter false for cruisecontrol (default for family cars!");
        boolean cc = input.nextBoolean();
        System.out.println("Enter number of seats");
        int s = input.nextInt();


        Family familyAdd = new Family(b, m, f, nr, year, month, om, g, ac, cc, s);
        FileWriter fileWriter = new FileWriter("Familie biler.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(familyAdd + "\n\n");
        bufferedWriter.close();
        fileWriter.close();
        familyList.add(familyAdd);
    }

    public String toString(){
        String g = "";
        if(gear){
            g = "Manuel gear";
        }else
            g = "Automat gear";
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nGear type: "+g+"\nAir condition: "+airCondition+
                "\nCruise Control: "+cruiseControl+"\nAntal Sæder: "+seats+"\nRegistreringsnummer: "
                +regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"km");
    }
}
