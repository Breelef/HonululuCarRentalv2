package com.company;

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

    public String toString(){
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nRegistreringsnummer: "
                +regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"km");
    }
}