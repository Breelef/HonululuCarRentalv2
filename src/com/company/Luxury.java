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
    public static void changeLuxury(ArrayList<Luxury> list) throws IOException {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Nr. " + (i + 1) + "\n" + list.get(i));
        }
        System.out.print("Enter the number of the luxury car you want to edit: ");
        int changeNumber = scan.nextInt();
        System.out.println();
        Luxury tempObject = list.get((changeNumber - 1));
        String changeList = tempObject.toString();

        String showNumbersList = changeList
                .replace("Mærke", "1 - Mærke")
                .replace("Model", "2 - Model")
                .replace("Benzin type", "3 - Benzin type")
                .replace("Gear type", "4 - Gear type")
                .replace("Air condition", "5 - Air condition")
                .replace("Cruise Control", "6 - Cruise Control")
                .replace("Type Sæde", "7 - Type Sæde")
                .replace("Størrelse på bilen", "8 - Størrelse på bilen")
                .replace("Registreringsnummer", "9 - Registreringsnummer")
                .replace("Registreringsdato", "10 - Registreringsdato")
                .replace("Bilen har kørt", "11 - Bilen har kørt")
                .replace("*********************************", "");
        System.out.print("Luxury car nr. " + changeNumber + ":\n\n" + showNumbersList);

        System.out.print("Enter the number of the information you want to edit: ");
        System.out.println();
        int infoNumber = scan.nextInt();
        scan.nextLine();       //Stops the next line from getting "eaten"
        switch (infoNumber) {
            case 1:
                System.out.print("Enter new brand: ");
                tempObject.brand = scan.nextLine();
                break;
            case 2:
                System.out.print("Enter new model: ");
                tempObject.model = scan.nextLine();
                break;
            case 3:
                System.out.print("Enter new fuel type: ");
                tempObject.fuel = scan.nextLine();
                break;
            case 4:
                System.out.print("Enter new registration number: ");
                tempObject.regNr = scan.nextInt();
                break;
            case 5:
                System.out.print("Enter new production year: ");
                tempObject.regYear = scan.nextInt();
                break;
            case 6:
                System.out.print("Enter new production month: ");
                tempObject.regMonth = scan.nextInt();
                break;
            case 7:
                System.out.print("Enter new total amount of travel distance of the car: ");
                tempObject.odoMeter = scan.nextInt();
                break;
            case 8:
                System.out.print("Enter new size: ");
                tempObject.size = scan.nextInt();
                break;
            case 9:
                System.out.print("Enter new gear type (type false for automatic gear, true for no automatic gear): ");
                tempObject.gear = scan.nextBoolean();
                break;
            case 10:
                System.out.println("Enter new AC type (type true for AC,false for no AC): ");
                tempObject.airCondition = scan.nextBoolean();
            case 11:
                System.out.println("Enter new cruise control (type true for cruise control, false for no cruise control): ");
                tempObject.cruiseControl = scan.nextBoolean();
            default:
                System.out.println("Number " + infoNumber + " is not not a valid option");
                break;
        }

        System.out.println("\nLuxury car nr. " + changeNumber + " with the edit: ");
        list.set((changeNumber - 1), tempObject);
        System.out.println(list.get(changeNumber - 1));

        //Prints the updated ArrayList to the file
        FileWriter writer = new FileWriter("luxurycars");
        for (Luxury p : list) {
            writer.write(p + System.lineSeparator());
        }
        writer.close();
    }

        public static void addLuxury(ArrayList<Luxury> luxuryList) throws IOException {
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
        FileReader fr = new FileReader("src/com/company/luxurycars");
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
