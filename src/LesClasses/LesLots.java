package LesClasses;


import java.util.*;

public class LesLots {

    private ArrayList<Lot> lstL;

    //Constructeur par défaut
    public LesLots() {
        this.lstL = new ArrayList<>();
    }

    //Méthode pour récupérer un lot
    public Lot getLot(int i) {
        return this.lstL.get(i);
    }

    //Méthode pour savoir le nombre de lots
    public int getNbLots() {
        return this.lstL.size();
    }

    //Méthode pour ajouter un lot
    public void ajouteLot(Lot l) {
        this.lstL.add(l);
    }

    // Méthode pour supprimer un lot
    public void supprimeLot(Lot l) {
        this.lstL.remove(l);
    }

    // Affichage de tous les lots
    @Override
    public String toString() {
        String mes = "";
        for (int i = 0; i < getNbLots(); i++) {
            mes += "Lot n°" + (i + 1) + " : " + this.getLot(i).toString() + " ; ";
        }
        return mes;
    }
}
