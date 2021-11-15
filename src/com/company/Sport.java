package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sport extends Vehicle{
    boolean gear;
    int HP;

    public Sport(String b, String m, String f, int nr, int year, int month, int om, boolean g, int hp){
        super(b, m, f, nr, year, month, om);
        gear = g;
        HP = hp;
    }

    public static void addSport(ArrayList<Sport> sportList)throws IOException {
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
        System.out.println("Enter false for automatic gear (default for sports cars!)");
        boolean g = input.nextBoolean();
        System.out.println("Enter horsepower for the car" );
        int hp = input.nextInt();


        Sport sportAdd = new Sport(b, m, f, nr, year, month, om, g, hp);
        FileWriter fileWriter = new FileWriter("Sports biler.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(sportAdd + "\n\n");
        bufferedWriter.close();
        fileWriter.close();
        sportList.add(sportAdd);
    }

    @Override
    public String toString(){
        String g;
        if(gear){
            g = "Manuel gear";
        }else
            g = "Automat gear";
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nGear type: "+g+
                "\nHorse Power: "+HP+"\nRegistreringsnummer: "+regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"km");
    }
}