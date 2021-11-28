package champollion;

import java.util.Objects;

public class UE {
    private final String myIntitule;
    public int heureCM;
    public int heureTD;
    public int heureTP;

    public UE(String intitule) {
        myIntitule = intitule;
    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeureCM() {
        return heureCM;
    }

    public int getHeureTD() {
        return heureTD;
    }

    public int getHeureTP() {
        return heureTP;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.myIntitule);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UE other = (UE) obj;
        if (!Objects.equals(this.myIntitule, other.myIntitule)) {
            return false;
        }
        return true;
    }
    
    
}
