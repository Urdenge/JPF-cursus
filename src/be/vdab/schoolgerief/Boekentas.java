package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.voertuigen.div.Maat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {
private static final long serialVersionUID = 1L;

    String kleur;
    Volume laadvolume;

    
    public Boekentas(String kleur, Volume laadvolume) {
        setKleur(kleur);
        setLaadvolume(laadvolume);
    }

    
    public String getKleur() {
        return kleur;
    }

    public final void setKleur(String kleur) throws IllegalArgumentException {
        if ( (kleur == null) || kleur.trim().isEmpty() )
            throw new IllegalArgumentException ("Kleur moet ingevuld zijn");
        else
            this.kleur = kleur;
    }   

    //In BigDecimal voor evt. afronding...
    public BigDecimal getInhoud(){
//        return BigDecimal.valueOf(laadvolume.getVolume()).setScale(2, RoundingMode.HALF_UP);
//        BigDecimal inhoud = BigDecimal.valueOf(laadvolume.getVolume()).setScale(2, RoundingMode.HALF_UP);
//        BigDecimal deelMaat = BigDecimal.valueOf(Maat.METER.getMaatRatio());
//        return inhoud.divide(deelMaat);
        return BigDecimal.valueOf(laadvolume.getVolume()).setScale(2, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(Maat.METER.getMaatRatio()));
    }
        
    
    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public final void setLaadvolume(Volume laadvolume) throws IllegalArgumentException {
        if (laadvolume != null)
            this.laadvolume = laadvolume;
        else
            throw new IllegalArgumentException ("Laadvolume niet opgegeven");
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.kleur);
        hash = 71 * hash + Objects.hashCode(this.laadvolume);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Boekentas)){
            return false;
        }
        
        Boekentas other = (Boekentas) obj;
        if (!Objects.equals(this.kleur, other.kleur)) {
            return false;
        }
        if (!Objects.equals(this.laadvolume, other.laadvolume)) {
            return false;
        }
        return true;        
    }    
    
    @Override
    public String toString() {
        return kleur + " ; " + laadvolume;
    }
}
