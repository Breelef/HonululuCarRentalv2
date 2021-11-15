package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Luxury extends Vehicle{
    int size;
    boolean gear;
    boolean airCondition;
    boolean cruiseControl;
    String seats;

    public Luxury(String b, String m, String f, int nr, int year, int month, int om, int str, boolean g, boolean ac, boolean cc, String s){
        super(b, m, f, nr, year, month, om);
        size = str;
        gear = g;
        airCondition = ac;
        cruiseControl = cc;
        seats = s;
    }

    public static void addLuxury(ArrayList<Luxury> luxuryList)throws IOException {
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
        System.out.println("Enter size of the car");
        int str = input.nextInt();
        System.out.println("Enter false for automatic gear (default for luxury cars!)");
        boolean g = input.nextBoolean();
        System.out.println("Enter false for AC (default for luxury cars!)");
        boolean ac = input.nextBoolean();
        System.out.println("Enter true for cruisecontrol (default for luxury cars!");
        boolean cc = input.nextBoolean();
        System.out.println("Enter seat material type");
        String s = input.nextLine();


        Luxury luxuryAdd = new Luxury(b, m, f, nr, year, month, om, str, g, ac, cc, s);
        FileWriter fileWriter = new FileWriter("luxurycars.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(luxuryAdd + "\n\n");
        bufferedWriter.close();
        fileWriter.close();
        luxuryList.add(luxuryAdd);
    }

    public String toString(){
        String g = "";
        if(gear){
            g = "Manuel gear";
        }else
            g = "Automatic gear";
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nGear type: "+g+"\nAir condition: "+airCondition+
                "\nCruise Control: "+cruiseControl+"\nType Sæde: "+seats+"\nStørrelse på bilen: "+size+"cm"+
                "\nRegistreringsnummer: " +regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"km");
    }
}
