package com.company;

public class Main {

    public static void main(String[] args) {
        //boolean gear: true = manuel gear, false = automat gear
        Sport audi = new Sport("Audi", "R8", "Diesel", 2123122, 2021, 7, 29000, true,550);
        Family vw = new Family("Volkswagen", "Golf", "Benzin", 44221231, 2021, 9, 33000, true, true, false, 5);
        Luxury rr = new Luxury("Rolls-Royce", "Phantom VIII", "Benzin", 31231232, 2020, 2, 19000, 3230, false, true, true, "Lædersæder");
        System.out.println(audi);
        System.out.println(vw);
        System.out.println(rr);
    }

}