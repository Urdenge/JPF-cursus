package be.vdab.util;
import java.io.Serializable;
import be.vdab.voertuigen.div.Maat;
import java.util.Objects;

public final class Volume_save implements Serializable, Comparable<Volume_save>  {
private static final long serialVersionUID = 1L;

    private int breedte;
    private int hoogte;
    private int diepte;
    private final Maat maat;

    
    public Volume_save(int breedte, int hoogte, int diepte, Maat maat) throws VolumeException {
        setBreedte(breedte);
        setHoogte(hoogte);
        setDiepte(diepte);
        this.maat = maat;
    }

    private final void setBreedte(int breedte) throws VolumeException {
        if (breedte > 0)
            this.breedte = breedte;
        else
            throw new VolumeException("Negatief volume niet toegestaan");
    }

    private final void setHoogte(int hoogte) throws VolumeException {
        if (hoogte > 0)
            this.hoogte = hoogte;
        else
            throw new VolumeException("Negatief volume niet toegestaan");
    }

    private final void setDiepte(int diepte) throws VolumeException {
        if (diepte > 0)
            this.diepte = diepte;
        else
            throw new VolumeException("Negatief volume niet toegestaan");
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
        if (!(obj instanceof Volume_save)) {
            return false;
        }
        Volume_save vol = (Volume_save) obj;
        return getVolume() == vol.getVolume();
    }

    @Override
    public int compareTo(Volume_save inh) {
        long inhoud = (long) (breedte * hoogte * diepte * maat.getMaatRatio());
        return (int) (inhoud - inh.getVolume()) ;
    }                  
        
    
    @Override
    public String toString() {
        return breedte + " ; " + hoogte + " ; " + diepte + " ; " + maat + getVolume();
    }
}