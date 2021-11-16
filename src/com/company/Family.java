package com.company;

import java.io.*;
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
        FileWriter fileWriter = new FileWriter("Recourses/Familie biler.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(familyAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        familyList.add(familyAdd);
        System.out.println("Vil du se oversigt over bilerne?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("ja")){
            for (int i = 0; i < familyList.size(); i++) {
                System.out.println(familyList.get(i));
            }
        }
    }
    public static void addToArrays(ArrayList<Family> familyList) throws IOException {
        FileReader fr = new FileReader("Recourses/Familie biler.txt");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String brand = "";
        String model = "";
        String gas = "";
        boolean gear = true;
        boolean cc = true;
        boolean ac = true;
        int regNr = 0;
        int dateM = 0;
        int dateY = 0;
        int odoM = 0;
        int seats = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Mærke")) {
                brand = line.split(":")[1].trim();
            }
            if (line.contains("Model")) {
                model = line.split(":")[1].trim();
            }
            if (line.contains("Benzin type")) {
                gas = line.split(":")[1].trim();
            }
            if(line.contains("Cruise control")){
                useMe = line.split(":")[1].trim();
                cc = Boolean.parseBoolean(useMe);
            }
            if(line.contains("Antal Sæder")){
                useMe = line.split(":")[1].trim();
                seats = Integer.parseInt(useMe);
            }
            if (line.contains("Registreringsnummer")) {
                useMe = line.split(":")[1].trim();
                regNr = Integer.parseInt(useMe);
            }
            if (line.contains("Registreringsdato")) {
                useMe = line.split(":")[1].trim();
                String dateMonth = useMe.substring(0, useMe.indexOf('/'));
                dateM = Integer.parseInt(dateMonth);
                String dateYear = useMe.substring(useMe.indexOf('/')+1);
                dateY = Integer.parseInt(dateYear);
            }
            if (line.contains("Bilen har kørt")) {
                useMe = line.split(":")[1].trim();
                odoM = Integer.parseInt(useMe);
            }
            if(line.contains("*********************************")){
                Family familyAdd = new Family(brand, model, gas, regNr, dateY, dateM, odoM, gear, ac, cc, seats);
                familyList.add(familyAdd);
            }
        }
        br.close();
        fr.close();
    }

    public String toString(){
        String g = "";
        if(gear){
            g = "Manuel gear";
        }else
            g = "Automat gear";
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nGear type: "+g+"\nAir condition: "+airCondition+
                "\nCruise Control: "+cruiseControl+"\nAntal Sæder: "+seats+"\nRegistreringsnummer: "
                +regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"\n*********************************");
    }
}
