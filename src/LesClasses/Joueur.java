package LesClasses;

import java.awt.*;
import javax.swing.*;

public class Joueur {

    private String pseudo;
    private Color couleur;
    private double solde;
    private ImageIcon photo;
    private LesCartes mesC;
    private LesLots mesL;

    // Accesseurs
    public String getPseudo() {
        return this.pseudo;
    }

    public Color getCouleur() {
        return this.couleur;
    }

    public double getSolde() {
        return this.solde;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }

    public LesCartes getMesCartes() {
        return mesC;
    }

    public LesLots getMesLots() {
        return mesL;
    }

    public void setPseudo(String p) {
        this.pseudo = p;
    }

    public void setCouleur(Color c) {
        this.couleur = c;
    }

    public void setPhoto(ImageIcon p) {
        this.photo = p;
    }

    public void setSolde(double s) {
        this.solde = s;
    }
    // Constructeurs
    // Par défaut
    public Joueur() {
        this.pseudo = "";
        this.couleur = Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/LesImages/joueurDefaut.png"));
        this.mesC = new LesCartes();
        this.mesL = new LesLots();

    }
    // avec un pseudo en paramètre.

    public Joueur(String p) {
        this.pseudo = p;
        this.couleur = Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/LesImages/joueurDefaut.png"));
        this.mesC = new LesCartes();
        this.mesL = new LesLots();

    }

    // Méthode pour acheter une carte.
    public boolean acheter(CarteLoto c) {
        if (this.solde >= c.getPrix() && this.mesC.getTaille() < 3) {
            this.mesC.ajouteCarte(c);
            this.solde -= c.getPrix();
            return true;
        } else {
            return false;
        }
    }

    // Affichage du joueur.
    @Override
    public String toString() {
        String res = "Joueur : " + this.pseudo;
        res += "\nCouleur : " + this.couleur;
        res += "\nSolde : " + this.solde;
        res += "\nNombre de cartes possédées : " + this.mesC.getTaille();
        res += "\nListe des lots  : \n" + this.mesL.toString();
        return res;
    }
}
