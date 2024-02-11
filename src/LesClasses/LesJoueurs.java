package LesClasses;


import java.util.*;

public class LesJoueurs {

    private ArrayList<Joueur> jlst;

    // Constructeur par défaut
    public LesJoueurs() {
        this.jlst = new ArrayList<>();
    }

    // Accesseurs pour récupérer un joueur et le nombre de joueurs total dans la collection.
    public Joueur getJoueur(int i) {
        return this.jlst.get(i);
    }

    public int getNbJoueurs() {
        return this.jlst.size();
    }

    // Méthodes pour ajouter un joueur, supprimer un joueur la liste et vider la liste
    public void ajouteJoueur(Joueur J) {
        this.jlst.add(J);
    }

    public void supprimeJoueur(Joueur J) {
        this.jlst.remove(J);
    }

    public void supprimeAll() {
        jlst.clear();
    }

    // Méthode pour rechercher un joueur dans la liste
    public Joueur rechJoueur(String ps) {
        Joueur search = null;
        for (int i = 0; i < this.getNbJoueurs(); i++) {
            if (this.getJoueur(i).equals(ps)) {
                search = this.getJoueur(i);
            }
        }
        return search;
    }
    // Affichage des joueurs
    @Override
    public String toString() {
        String mes = "";
        for (int i = 0; i < getNbJoueurs(); i++) {
            mes += "Joueur n°" + (i + 1) + "\n" + getJoueur(i).toString();
        }
        return mes;
    }

}
