package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

public class Vrachtwagen extends Voertuig implements Laadbaar {

    private Volume laadvolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;

    
    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen) {
        super(merk, aankoopprijs);
        setLaadvolume(laadvolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }

    
    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public final void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if (maximaalToegelatenMassa > 0)
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public final void setAantalAssen(int aantalAssen) {
        if (aantalAssen > 0)
            this.aantalAssen = aantalAssen;
    }


    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public final void setLaadvolume(Volume laadvolume) {
        if (laadvolume != null)
            this.laadvolume = laadvolume;
    }
    
   
    @Override
    public String toString() {
        return super.toString() + " ; " + laadvolume.getVolume() + " ; " + maximaalToegelatenMassa + " ; " + aantalAssen;
    }
}