package LesClasses;


import java.awt.*;
import javax.swing.*;

public class CarteLoto {

    private int tab[][];
    private int jetons[][];
    private int nbCol;
    private int nbLig;
    private int nbNumeros;
    private double prix;
    private final int valMax = 90;

    //Constructeur par défaut
    public CarteLoto() {
        this.nbNumeros = 15;
        this.nbCol = 9;
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeursCarte();
    }

    //Constructeur avec paramètres
    public CarteLoto(int nbc, int nbVal) {
        this.nbNumeros = nbVal;
        this.nbCol = nbc;
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeursCarte();
    }

    //Accesseurs
    public void setNbNumeros(int nbNumeros) {
        if (nbNumeros > 3 && nbNumeros < nbCol * nbLig) {
            this.nbNumeros = nbNumeros;
        }
    }

    public int getCase(int i, int j) {
        return tab[i][j];
    }

    public int getNbCol() {
        return nbCol;
    }

    public int getNbLig() {
        return nbLig;
    }

    public double getPrix() {
        return this.prix;
    }

    public double getNbNumeros() {
        return this.nbNumeros;
    }

    //Méthodes
    // Permet de vérifier si une valeur est sur la carte ou non
    public boolean estDans(int val) {
        boolean res = false;
        int i = 0;
        do {
            int j = 0;
            while (j < this.nbCol && this.tab[i][j] != val) {
                j++;
            }
            if (j < this.nbCol) {
                res = true;
            } else {
                i++;
            }
        } while (i < this.nbLig && res == false);
        return res;
    }

    // On crée la carte en évitant les doublons
    private void initValeursCarte() {
        int i = 0;
        int j = 0;
        int val = 0;

        for (int k = 0; k < this.nbNumeros; k++) {
            do {
                val = (int) (Math.random() * this.valMax + 1);
            } while (estDans(val));

            do {
                j = (int) (Math.random() * this.nbCol);
            } while (tab[i][j] != 0);

            tab[i][j] = val;
            i = (i + 1) % nbLig;
        }

    }

    // On indique l'emplacement du nombre s'il est tiré ou non
    public boolean placePion(int val) {
        boolean res = false;
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (tab[i][j] == val) {
                    res = true;
                    jetons[i][j] = val;
                }
            }
        }
        return res;
    }

    // On indique si une ligne est pleine
    public boolean estLignePleine(int lig) {
        boolean res = true;
        for (int j = 0; j < this.nbCol; j++) {
            if (jetons[lig][j] != tab[lig][j]) {
                res = false;
            }
        }
        return res;
    }

    // On récupère le nombre de lignes pleines
    public int getNbLignesPleines() {
        int cpt = 0;
        for (int i = 0; i < this.nbLig; i++) {
            if (estLignePleine(i)) {
                cpt++;
            }
        }
        return cpt;
    }

    // On regarde si le carton est gagnant selon l'option
    public boolean cartonGagnant(int option) {
        boolean res = false;
        switch (option) {
            case 1:
                res = (getNbLignesPleines() == 1);
                break;
            case 2:
                res = getNbLignesPleines() == 2;
                break;
            case 3:
                res = getNbLignesPleines() == 3;
                break;
        }
        return res;
    }

    // Affichage de la carte sur un jPanel
    public void dessineCarte(JPanel jp, Color coul) {
        jp.removeAll();
        jp.setLayout(new GridLayout(nbLig, nbCol));
        for (int i = 0; i < nbLig; i++) {
            for (int j = 0; j < nbCol; j++) {
                JButton bouton = new JButton(Integer.toString(tab[i][j]));
                if (tab[i][j] == 0) {
                    bouton.setText("");
                }
                if (jetons[i][j] == 0) {
                    bouton.setBackground(coul);
                } else {
                    bouton.setBackground(Color.WHITE);
                }
                jp.add(bouton);
            }
        }
    }

    // Affichage des valeurs
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (tab[i][j] > 9) {
                    res += " " + tab[i][j];
                } else {
                    res += "  " + tab[i][j];
                }
            }
            res += "\n";
        }
        res += "\n";
        return res;
    }
}
