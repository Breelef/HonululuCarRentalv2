package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Contracts {
    int rentID;
    int companyID;
    String fromTime;
    String toTime;
    int maxKm;
    int odometer;
    int regNr;

    public Contracts(int rID, int cID, String fTime, String tTime, int mKM, int om, int regNummer){
        rentID = rID;
        companyID = cID;
        fromTime = fTime;
        toTime = tTime;
        maxKm = mKM;
        odometer = om;
        regNr = regNummer;
    }
    public Contracts(){
    }

    public static void addContracts(ArrayList<Contracts> contractList) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter rent ID");
        int rentID = input.nextInt();
        System.out.println("Enter company ID");
        int companyID = input.nextInt();
        System.out.println("Enter start time");
        String fromTime = input.nextLine();
        System.out.println("Enter end time time");
        String toTime = input.nextLine();
        System.out.println("Enter maximum KM costumer can travel");
        int maxKm = input.nextInt();
        System.out.println("Enter KM writen in the odometer before start");
        int odometer = input.nextInt();
        System.out.println("Enter registration number");
        int regNr = input.nextInt();
        Contracts newContract = new Contracts(rentID, companyID, fromTime, toTime, maxKm, odometer, regNr);
        //Skriver til fil
        writeToFile(contractList, newContract);
        System.out.println("Vil du se oversigt over contracts?");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("ja")){
            printArray(contractList);
        }
    }
    public static void writeToFile(ArrayList<Contracts> contractList, Contracts newContract) throws IOException{
        FileWriter fileWriter = new FileWriter("Contracts", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(newContract + "\n");
        bufferedWriter.close();
        fileWriter.close();
        contractList.add(newContract);

    }
    public static void addToArrays(ArrayList<Contracts> contractsList) throws IOException {
        FileReader fr = new FileReader("Recourses/Contracts");
        BufferedReader br = new BufferedReader(fr);
        String useMe = "";
        int rentID = 0;
        int companyID = 0;
        String rentalStart = "";
        String rentalStop = "";
        int maxKM = 0;
        int odoM = 0;
        int regNr = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("Rent ID")) {
                useMe = line.split(":")[1].trim();
                rentID = Integer.parseInt(useMe);
            }
            if (line.contains("Company ID")) {
                useMe = line.split(":")[1].trim();
                companyID = Integer.parseInt(useMe);
            }
            if (line.contains("Rental start")) {
                rentalStart = line.split(":")[1].trim();
            }
            if (line.contains("End of rental")) {
                rentalStop = line.split(":")[1].trim();
            }
            if (line.contains("Max KM")) {
                useMe = line.split(":")[1].trim();
                maxKM = Integer.parseInt(useMe);
            }
            if (line.contains("KM at start of rental")) {
                useMe = line.split(":")[1].trim();
                odoM = Integer.parseInt(useMe);
            }
            if (line.contains("Cars reg nr.")) {
                useMe = line.split(":")[1].trim();
                regNr = Integer.parseInt(useMe);
            }
            if(line.contains("*********************************")){
                Contracts contractAdd = new Contracts(rentID, companyID, rentalStart, rentalStop, maxKM, odoM, regNr);
                contractsList.add(contractAdd);
            }
        }
        br.close();
        fr.close();
    }
    public static void printArray(ArrayList<Contracts> contractList){
        for(int i = 0; i < contractList.size(); i++){
            System.out.println(contractList.get(i));
        }
    }
    public String toString(){
        return ("Rent ID: " + rentID + "\nCompany ID: " + companyID + "\nRental start: " + fromTime +
                "\nEnd of rental: " + toTime + "\nMax KM: " + maxKm + "\nKM at start of rental: " + odometer +
                "\nCars reg nr.: " + regNr + "\n*********************************");
    }
}
