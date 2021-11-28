package champollion;

import java.util.ArrayList;
import java.util.HashMap;

public class Enseignant extends Personne {
    public HashMap<UE, ServicePrevu> myServicesPrevus;
//public ArrayList<ServicePrevu> myServicesPrevus = new ArrayList<> ();
// TODO : rajouter les autres méthodes présentes dans le diagramme UML
        public ArrayList<Intervention> myInterventions;

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.myInterventions = new ArrayList <> ();
        this.myServicesPrevus = new HashMap<UE, ServicePrevu> ();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        int heuresPrev = 0;
        for (UE ue : myServicesPrevus.keySet()) {
            heuresPrev += heuresPrevuesPourUE(ue);
        }
        return heuresPrev;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        double p = 0;
        p = (myServicesPrevus.get(ue).getVolumeCM() * 1.5) + (myServicesPrevus.get(ue).getVolumeTP() * 0.75) + myServicesPrevus.get(ue).getVolumeTD();
        int heuresPrevuesPrUE = (int) p;
        return heuresPrevuesPrUE;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
            //ServicePrevu servicePrevu = new ServicePrevu(ue, volumeCM, volumeTD, volumeTP);
            //myServicesPrevus.add(volumeCM, volumeTD, volumeTP);
            if (!myServicesPrevus.containsKey(ue)) {
                ServicePrevu s = new ServicePrevu(volumeCM, volumeTD, volumeTP);
                myServicesPrevus.put(ue, s);
            }
            else {
                
                myServicesPrevus.get(ue).ajouterCM(volumeCM);
                myServicesPrevus.get(ue).ajouterTD(volumeTD);
                myServicesPrevus.get(ue).ajouterTP(volumeTP);
            }
    }

    //En sous service : le servic normal est de 192 heures, on cherche à si on a pas atteint cette horaire.
    public boolean enSousService() {
        boolean b = true;
        if (heuresPrevues() == 192) {
            b = false;
        }
        return b;
    }
    
    public void ajouterIntervention(Intervention intervention) {
        myInterventions.add(intervention);
    }
    
    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int reste = 0;
        int heureIntervention = 0;
        for (Intervention i : myInterventions) {
            if (i.getUe().equals(ue)) {
                if (i.getTypeIntervention() == type) {
                    heureIntervention += i.getDuree();
                }
            }
        }
        int heurePrevuUE = 0;
        if (type == TypeIntervention.CM) {
            heurePrevuUE += myServicesPrevus.get(ue).getVolumeCM();
        }
        if (type == TypeIntervention.TD) {
            heurePrevuUE += myServicesPrevus.get(ue).getVolumeTD();
        }
        if (type == TypeIntervention.TP) {
            heurePrevuUE += myServicesPrevus.get(ue).getVolumeTP();
        }
        
        reste = heurePrevuUE - heureIntervention;
        return reste;
    }
}
