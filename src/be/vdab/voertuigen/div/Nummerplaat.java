package be.vdab.voertuigen.div;
import java.util.Objects;
import java.io.Serializable;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
private static final long serialVersionUID = 1L;

    private final String plaat;

    
    protected Nummerplaat(String plaat) {
        this.plaat = plaat;
    }


    public String getPlaat() {
        return plaat;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.plaat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Nummerplaat)){
            return false;
        }
        Nummerplaat nrPlaat = (Nummerplaat) obj;
        return plaat.equals(nrPlaat.plaat);
    }

    @Override
    public int compareTo(Nummerplaat np) {
        return plaat.compareTo(np.getPlaat());
    }
    
    
    
    @Override
    public String toString() {
        return plaat;
    }

}
