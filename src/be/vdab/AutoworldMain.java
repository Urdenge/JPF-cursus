package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import java.io.FileOutputStream;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;
import be.vdab.voertuigen.div.Maat;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class AutoworldMain {

    public static void main(String[] args) throws VolumeException {

        SortedSet<Voertuig> wagens = new TreeSet<>();

        Volume vol1 = new Volume(2, 2, 1, Maat.METER);
        Volume vol2 = new Volume(18, 5, 19, Maat.DECIMETER);
        Volume vol3 = new Volume(3, 2, 20, Maat.METER);
        Volume vol4 = new Volume(3, 3, 80, Maat.METER);
        Volume vol5 = new Volume(40, 30, 10, Maat.CENTIMETER);
        Volume vol6 = new Volume(25, 35, 8, Maat.CENTIMETER);
        try{
            Volume vol7 = new Volume(-7, 5, -1, Maat.METER); //negatief volume exception
        }
        catch(VolumeException ex){
            System.out.println("Er was een foutje : " + ex + "\n");
        }
        
//        Nummerplaat plaat1 = new Nummerplaat("tekst");
//        System.out.println("\nNummerplaat test: " + plaat1);

        Personenwagen auto1 = new Personenwagen("Opel Astra", 17000, 4);
        Personenwagen auto2 = new Personenwagen("BMW 320", 23000, 4);
        Personenwagen auto3 = new Personenwagen("Ferrari Barchetta", 297000, 2);  
        Personenwagen auto4 = new Personenwagen("Ferrari Barchetta", 297000, 2);  // ! Dubbel..

        
        Pickup pick01 = new Pickup("Outlander", 79499, 5, vol2);
        Pickup pick02 = new Pickup("Land Rover", 59499, 6, vol1);
        Vrachtwagen camion1 = new Vrachtwagen("Mack", 399000, vol4, 970000, 8);

        
    // Voeg toe mix...        
        wagens.add(new Personenwagen("Volkswagen Passat", 28000, 5));
        wagens.add(new Pickup("Chevrolet", 45000, 3, vol2));
        wagens.add(new Pickup("Jeep", 55000, 5, new Volume(218, 17, 19, Maat.DECIMETER)));
        wagens.add(new Pickup("Dodge", 72500, 6, new Volume(4, 2, 1, Maat.METER)));
        wagens.add(new Vrachtwagen("DAF", 95000, vol3, 100000, 5));
        wagens.add(new Vrachtwagen("Scania", 110000, vol3, 368000, 7));

        // Null waarde...
        //wagens.add(null);
        
    // Voeg toe in gewijzigde aanmaakvolgorde/kentekensequentie...
        wagens.add(camion1);
        wagens.add(auto3);
        wagens.add(auto2);
        wagens.add(pick01);
        wagens.add(auto1);
        wagens.add(auto4);
        wagens.add(pick02); // ! Dubbel..

    // Tonen op scherm...
        for (Voertuig car : wagens) {
            System.out.println(car);
        }

    
    // Schrijven naar bestand van ieder object afzonderlijk...
        try (FileOutputStream fos = new FileOutputStream("H:/OefeningIO/wagenpark.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos); ){
             
            for (Voertuig car : wagens) {
                oos.writeObject(car);
            }
        }
        catch (IOException e) {
            System.out.println("Voertuigen kunnen niet weggeschreven worden!");
        }


//    // Schrijven naar bestand van de gehele collection tegelijk...
//        try (FileOutputStream fos = new FileOutputStream("H:/OefeningIO/wagenpark.dat");
//             ObjectOutputStream oos = new ObjectOutputStream(fos); ){
//
//            oos.writeObject(wagens);
//        }
//        catch (IOException e) {
//            System.out.println("Voertuigen kunnen niet weggeschreven worden!");
//        }        

        
    // Terug inlezen van bestand...
        Set<Voertuig> wagensInlezen = new TreeSet<>();
        Voertuig auto;
        
        try (FileInputStream fis = new FileInputStream("H:/OefeningIO/wagenpark.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);){

//        Gehele collectie tegelijk..
//            wagensInlezen = (Set<Voertuig>) ois.readObject();

//        Afzonderlijke objecten..            
            for (int i = 0; i < 100; i++) {
                auto = (Voertuig) ois.readObject();
                wagensInlezen.add(auto);
            }
        }
        catch (IOException e) {
        //System.out.println("Kan het bestand voor wagenpark niet vinden");
        }
        catch (ClassNotFoundException e) {
        System.out.println("Kan de klasse niet vinden : ");
        }
        
        // Tonen op scherm...
        System.out.println("\n\nTerug ingelezen van bestand wagenpark.dat...\n");
        for (Voertuig car : wagensInlezen) {
            System.out.println(car);
        }
        // Of...
        System.out.println("\n\n" + wagensInlezen);


//------------------------------------------------------------------------------        
//        Boekentassen...

        try{
            Boekentas tas1 = new Boekentas(" ", vol5); //kleur niet gevuld
        }
        catch(Exception ex){
            System.out.println("\nEr was een foutje : " + ex + "\n");
        }
        
        Boekentas tas2 = new Boekentas("bruin", vol5);        
        Boekentas tas3 = new Boekentas("blauw ", vol5);        
        Boekentas tas4 = new Boekentas("rood", vol6);        
        
        System.out.println("\n\nBoekentassen:");
        System.out.println("Tas 2) " + "Kleur: " + tas2.getKleur() + "  Laadvolume: " + tas2.getInhoud() + " m3");
        System.out.println("Tas 3) " + "Kleur: " + tas3.getKleur() + "  Laadvolume: " + tas3.getInhoud() + " m3");
        System.out.println("Tas 4) " + "Kleur: " + tas4.getKleur() + "  Laadvolume: " + tas4.getInhoud() + " m3");
        
        
        Laadbaar[] lading = new Laadbaar[5];

            lading[0] = camion1;
            lading[1] = pick01;
            lading[2] = tas2;
            lading[3] = pick02;
            lading[4] = tas4;

        BigDecimal totBigLaadvolume = BigDecimal.ZERO;
        long totLaadvolume = 0L;

        System.out.println("\n\nInterface Laadbaar...");
        for (Laadbaar eenLading : lading) {
            System.out.println(eenLading);
            totBigLaadvolume = totBigLaadvolume.add(BigDecimal.valueOf(eenLading.getLaadvolume().getVolume()));
            totLaadvolume += (eenLading.getLaadvolume().getVolume() / Maat.METER.getMaatRatio());
        }
        
        System.out.println("\nTotaal laadvolume...");
        System.out.println(totLaadvolume + " m3");
        System.out.println(totBigLaadvolume.setScale(2, RoundingMode.HALF_UP) + " cm3");   
        System.out.println(totBigLaadvolume.divide(BigDecimal.valueOf(Maat.METER.getMaatRatio())).setScale(2, RoundingMode.HALF_UP) + " m3");               
    }
}
