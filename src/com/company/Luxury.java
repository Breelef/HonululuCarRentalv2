package com.company;

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

    public Luxury(){
    }

    public String toString(){
        String g = "";
        if(gear){
            g = "Manuel gear";
        }else
            g = "Automat gear";
        return ("Mærke: "+brand+"\nModel: "+model+"\nBenzin type: "+fuel+"\nGear type: "+g+"\nAir condition: "+airCondition+
                "\nCruise Control: "+cruiseControl+"\nType Sæde: "+seats+"\nStørrelse på bilen: "+size+"cm"+
                "\nRegistreringsnummer: " +regNr+"\nRegistreringsdato: "+regMonth+"/"+regYear+"\nBilen har kørt: "+odoMeter+"km");
    }
}
