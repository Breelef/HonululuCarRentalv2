package com.company;

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

    public Family(){
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
