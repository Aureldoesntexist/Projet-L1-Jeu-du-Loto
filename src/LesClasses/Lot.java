package LesClasses;


import javax.swing.*;

public class Lot {

    private String name;
    private int montant;
    private ImageIcon picture;

    // Accesseurs des attributs
    public String getDescriptif() {
        return name;
    }

    public double getMontant() {
        return montant;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public void setDescriptif(String name) {
        this.name = name;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setPicture(ImageIcon picture) {
        this.picture = picture;
    }

    // Constructeur par défaut
    public Lot() {
        this.name = "";
        this.montant = 0;
        this.picture = null;
    }

    // Constructeur pour un objet
    public Lot(String nom) {
        this.name = nom;
        this.montant = 0;
        this.picture = null;
    }

    // Constructeur pour un bon d'achat.
    public Lot(String nom, int montant) {
        this.name = nom;
        this.montant = montant;
        this.picture = null;
    }

    // Affichage si c'est un objet ou un bon d'achat    
    @Override
    public String toString() {
        if (picture == null) {
            return "Bon d'achat " + this.getDescriptif() + " de " + this.getMontant() + "€";
        } else {
            return this.getDescriptif();
        }

    }

}
