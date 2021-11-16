package com.company;

import java.io.*;
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
        System.out.println("Vil du se oversigt over bilerne?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("ja")){
            for (int i = 0; i < sportList.size(); i++) {
                System.out.println(sportList.get(i));
            }
        }
    }
    public static void addToArrays(ArrayList<Sport> sportList) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\emil_\\datamatiker\\Honululu car rental v2\\Sports Biler.txt");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        String brand = "";
        String model = "";
        String gas = "";
        boolean gear = true;
        int regNr = 0;
        int dateM = 0;
        int dateY = 0;
        int odoM = 0;
        int hp = 0;
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
            if(line.contains("Horse Power")){
                useMe = line.split(":")[1].trim();
                hp = Integer.parseInt(useMe);
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
                Sport sportAdd = new Sport(brand, model, gas, regNr, dateY, dateM, odoM, gear, hp);
                sportList.add(sportAdd);
            }
        }
        br.close();
        fr.close();
        System.out.println(sportList);
    }

    @Override
    public String toString(){
        String g;
        if(gear){
            g = "Manuel gear";
        }else
            g = "Automat gear";
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nGear type: "+g+
                "\nHorse Power: "+HP+"\nRegistreringsnummer: "+regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"\n*********************************");
    }
}