package LesClasses;


import java.util.*;

public class LesCartes {

    private ArrayList<CarteLoto> lst;

    // Constructeur.
    public LesCartes() {
        this.lst = new ArrayList<>();
    }

    // Nombre de cartes dans la liste.
    public int getTaille() {
        return this.lst.size();
    }

    // Accesseurs
    public CarteLoto getCarte(int i) {
        return this.lst.get(i);
    }

    // Ajout et suppression des cartes dans la liste.
    public void ajouteCarte(CarteLoto c) {
        this.lst.add(c);
    }

    public void supprimeCarte(CarteLoto c) {
        for (int i = 0; i < getTaille(); i++) {
            if (getCarte(i).equals(c)) {
                this.lst.remove(i);
            }
        }
    }

    public void supprimeAllCartes() {
        this.lst.clear();
    }

    // Recherche d'une carte dans la liste
    public LesCartes rechCartes(int num) {
        LesCartes ll = new LesCartes();
        for (int i = 0; i < getTaille(); i++) {
            if (getCarte(i).estDans(num)) {
                ll.ajouteCarte(getCarte(i));
            }
        }
        return ll;
    }
    
    // Méthode d'initialisation.
    public void initLesCartes(int n, int nbCol, int nbVal) {
        for (int i = 0; i < n; i++) {
            CarteLoto c = new CarteLoto(nbCol, nbVal);
            ajouteCarte(c);
        }
    }
    
    // Affichage des cartes.
    @Override
    public String toString() {
        String mes = "";
        for (int i = 0; i < getTaille(); i++) {
            mes += "Carte n°" + (i + 1) + "\n" + this.getCarte(i).toString();
        }
        return mes;
    }

}
