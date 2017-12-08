package be.vdab.voertuigen;
import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Objects;


public abstract class Voertuig implements Comparable<Voertuig>, Serializable {
private static final long serialVersionUID = 1L;
    
    private final Nummerplaat nummerplaat = Div.INSTANCE.getNummerplaat();
    private String merk;
    private int aankoopprijs;

    
    public Voertuig(String merk, int aankoopprijs) {
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }

    
    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return merk;
    }

    public final void setMerk(String merk) {
        if (merk != null && !merk.isEmpty())
            this.merk = merk;
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public final void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs > 0)
            this.aankoopprijs = aankoopprijs;
    }

        
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nummerplaat);
        return hash;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Voertuig)) {
            return false;
        }
        Voertuig v = (Voertuig) obj;
        return nummerplaat.equals(v.getNummerplaat() );
    }
        

    @Override
    public int compareTo(Voertuig wagen) {
        return nummerplaat.compareTo(wagen.getNummerplaat());
    }    
    
    
    @Override
    public String toString() {
        return nummerplaat + " ; " + merk + " ; " + aankoopprijs;
    }
}
