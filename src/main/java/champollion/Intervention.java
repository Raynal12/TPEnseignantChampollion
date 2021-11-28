package champollion;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RAYNAL Philippe
 */
public class Intervention {
    public Date date;
    public int duree;
    public boolean annulee;
    private int heureDebut;
    
    private UE ue;
    private Salle salle;
    private TypeIntervention typeIntervention;

    public Intervention(Date date, int duree, int heureDebut, UE ue, TypeIntervention typeIntervention) {
        this.date = date;
        this.duree = duree;
        this.annulee = false;
        this.heureDebut = heureDebut;
        this.ue = ue;
        
        this.salle=salle;
        this.typeIntervention = typeIntervention;
    }

    public UE getUe() {
        return ue;
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getTypeIntervention() {
        return typeIntervention;
    }
    
}
