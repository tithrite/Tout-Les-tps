package com.estn.model;

import java.time.LocalDate;
import java.time.Period;

public class Employe {

    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateEmbauche;
    private double salaire;

    
    
    public Employe() {
    	
    	
    }

    
    
    
    public Employe(  int id,   String nom, String   prenom, LocalDate  dateEmbauche,   double salaire) {
    	
    	
        this.id =   id;
        this.nom =nom;
        this.prenom =  prenom;
        this.dateEmbauche = dateEmbauche;
        this.salaire =  salaire;
        
        
        
        
    }

    public int getId() { 
    	

    	return id; 
    	
    }
    public void setId(int id) { 
    	
    	this.id = id;
    	
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

    public LocalDate getDateEmbauche() { 
    	return dateEmbauche; 
    	}
    public void setDateEmbauche(LocalDate dateEmbauche) { 
    	this.dateEmbauche = dateEmbauche; 
    	
    }

    public double getSalaire() { 
    	return salaire;
    	
    }
    public void setSalaire(double salaire) {
    	this.salaire = salaire; 
    	
    }

    public int getExperience() {
    	
    	
        return Period.between(this.dateEmbauche, LocalDate.now()).getYears();
    }
}
