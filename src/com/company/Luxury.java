package com.company;

import java.io.*;
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
        input.nextLine();
        System.out.println("Enter seat material type");
        String s = input.nextLine();

        Luxury luxuryAdd = new Luxury(b, m, f, nr, year, month, om, str, g, ac, cc, s);
        FileWriter fileWriter = new FileWriter("luxurycars", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(luxuryAdd + "\n");
        bufferedWriter.close();
        fileWriter.close();
        luxuryList.add(luxuryAdd);
        System.out.println("Vil du se oversigt over bilerne?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("ja")){
            for (int i = 0; i < luxuryList.size(); i++) {
                System.out.println(luxuryList.get(i));
            }
        }
    }
    public static void addToArrays(ArrayList<Luxury> luxuryList) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\emil_\\datamatiker\\Honululu car rental v2\\luxurycars");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String brand = "";
        String model = "";
        String gas = "";
        boolean gear = false;
        boolean ac = true;
        boolean cc = true;
        String seat = "lædersæder";
        int size = 0;
        int regNr = 0;
        int dateM = 0;
        int dateY = 0;
        int odoM = 0;
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
            if (line.contains("Størrelse på bilen")) {
                useMe = line.split(":")[1].trim();
                size = Integer.parseInt(useMe);
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
                Luxury luxuryAdd = new Luxury(brand, model, gas, regNr, dateY, dateM, odoM, size, gear, ac, cc, seat);
                luxuryList.add(luxuryAdd);
            }
        }
        br.close();
        fr.close();
        System.out.println(luxuryList);
    }

    public String toString(){
        String g = "";
        if(gear){
            g = "Manuel gear";
        }else
            g = "Automatic gear";
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nGear type: "+g+"\nAir condition: "+airCondition+
                "\nCruise Control: "+cruiseControl+"\nType Sæde: "+seats+"\nStørrelse på bilen: "+size+
                "\nRegistreringsnummer: " +regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"\n*********************************");
    }
}
