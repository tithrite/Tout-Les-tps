package beans;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private String nom;
    private String prenom;
    private double note;

    
    public Etudiant() {}

    public Etudiant(String nom, String prenom, double note) {
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
    }

    
    public String getNom() { 
    	return nom; 
    	}
    public void setNom(String nom) { 
    	this.nom = nom; 
    	}

    public String getPrenom() { 
    	return prenom; 
    	}
    public void setPrenom(String prenom) { 
    	this.prenom = prenom; 
    	}

    public double getNote() { 
    	return note; 
    	}
    public void setNote(double note) {
    	this.note = note; 
    	}

    
    public void genererNoteAleatoire() {
        this.note = Math.random() * 20;  
    }
}