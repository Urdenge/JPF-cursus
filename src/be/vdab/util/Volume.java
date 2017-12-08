package be.vdab.util;
import java.io.Serializable;
import be.vdab.voertuigen.div.Maat;
import java.util.Objects;

public final class Volume implements Serializable, Comparable<Volume>  {
private static final long serialVersionUID = 1L;

    private final int breedte;
    private final int hoogte;
    private final int diepte;
    private final Maat maat;

    
    public Volume(int breedte, int hoogte, int diepte, Maat maat) throws VolumeException {
        if (breedte > 0)
            this.breedte = breedte;
        else
            throw new VolumeException("Negatief volume niet toegestaan");
        if (hoogte > 0)
            this.hoogte = hoogte;
        else
            throw new VolumeException("Negatief volume niet toegestaan");
        if (diepte > 0)
            this.diepte = diepte;
        else
            throw new VolumeException("Negatief volume niet toegestaan");
        this.maat = maat;
    }

    
    public long getVolume(){
        return (long) (breedte * hoogte * diepte * maat.getMaatRatio());
    }
    
    public long getMaat(){
        return maat.getMaatRatio();
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.breedte;
        hash = 13 * hash + this.hoogte;
        hash = 13 * hash + this.diepte;
        hash = 13 * hash + Objects.hashCode(this.maat);
        return hash;
    }

        
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Volume)) {
            return false;
        }
        Volume vol = (Volume) obj;
        return getVolume() == vol.getVolume();
    }

    @Override
    public int compareTo(Volume inh) {
        long inhoud = (long) (breedte * hoogte * diepte * maat.getMaatRatio());
        return (int) (inhoud - inh.getVolume()) ;
    }                  
        
    
    @Override
    public String toString() {
        return breedte + " ; " + hoogte + " ; " + diepte + " ; " + maat + getVolume();
    }
}