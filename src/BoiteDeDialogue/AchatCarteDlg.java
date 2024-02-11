package BoiteDeDialogue;


import LesClasses.Joueur;
import LesClasses.CarteLoto;
import LesClasses.LesJoueurs;
import java.awt.*;
import javax.swing.*;

public class AchatCarteDlg extends JDialog {

    private LesJoueurs ljc;
    private int nbCol, nbLig, nbNum;
    private Joueur jc;
    private CarteLoto cc;
    private boolean achat;

    public AchatCarteDlg(Frame parent, boolean modal, LesJoueurs lj, int lig, int col, int val) {
        super(parent, modal);
        initComponents();
        // On initialise les attributs avec les paramètres
        this.ljc = lj;
        this.nbCol = col;
        this.nbLig = lig;
        this.nbNum = val;
        // Le boolean permet d'indiquer si le joueur a au moins une carte
        this.achat = false;
        // On initialise le joueur et on affiche son solde sur la jDialog
        this.jc = this.ljc.getJoueur(0);
        this.JoueurSolde.setText("Solde de " + this.jc.getPseudo() + " : " + this.jc.getSolde() + " €");
        // On crée une carte et on l'affiche dans la fenêtre
        this.cc = new CarteLoto(this.nbCol, this.nbNum);
        remplirListeJoueurs();
        initCarte();
        afficheCarte();
    }

    public boolean isAchat() {
        return achat;
    }

    // On remplit la JCB des pseudos des joueurs.
    private void remplirListeJoueurs() {
        for (int i = 0; i < this.ljc.getNbJoueurs(); i++) {
            this.ListeJ.addItem(this.ljc.getJoueur(i).getPseudo());
        }
    }

    // On crée la structure de la carte à acheter dynamiquement.
    private void initCarte() {
        this.PanneauCarte.setLayout(new GridLayout(this.nbLig, this.nbCol));
        for (int i = 0; i < this.nbLig * this.nbCol; i++) {
            JButton bouton = new JButton();
            this.PanneauCarte.add(bouton);
        }
    }

    // On affiche les valeurs de la carte.
    private void afficheCarte() {
        for (int i = 0; i < this.cc.getNbLig(); i++) {
            for (int j = 0; j < this.cc.getNbCol(); j++) {
                JButton bt = (JButton) this.PanneauCarte.getComponent(i * this.nbCol + j);
                int val = this.cc.getCase(i, j);
                if (val == 0) {
                    bt.setText(" ");
                } else {
                    bt.setText(" " + val);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanTitre = new javax.swing.JPanel();
        Titre = new javax.swing.JLabel();
        PanneauCarte = new javax.swing.JPanel();
        InfoConfigPan = new javax.swing.JPanel();
        InfoSoldePan = new javax.swing.JPanel();
        JoueurSolde = new javax.swing.JLabel();
        ConfigMenuPan = new javax.swing.JPanel();
        ListeJ = new javax.swing.JComboBox<>();
        AutreChoix = new javax.swing.JButton();
        Acheter = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        Titre.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titre.setText("Acheter une ou plusieurs cartes");
        PanTitre.add(Titre);

        getContentPane().add(PanTitre, java.awt.BorderLayout.NORTH);
        getContentPane().add(PanneauCarte, java.awt.BorderLayout.CENTER);

        InfoConfigPan.setLayout(new java.awt.GridLayout(2, 1));

        InfoSoldePan.setLayout(new java.awt.BorderLayout());

        JoueurSolde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InfoSoldePan.add(JoueurSolde, java.awt.BorderLayout.CENTER);

        InfoConfigPan.add(InfoSoldePan);

        ListeJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeJActionPerformed(evt);
            }
        });
        ConfigMenuPan.add(ListeJ);

        AutreChoix.setText("Autre choix");
        AutreChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutreChoixActionPerformed(evt);
            }
        });
        ConfigMenuPan.add(AutreChoix);

        Acheter.setText("Acheter");
        Acheter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcheterActionPerformed(evt);
            }
        });
        ConfigMenuPan.add(Acheter);

        Fermer.setText("Quitter");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        ConfigMenuPan.add(Fermer);

        InfoConfigPan.add(ConfigMenuPan);

        getContentPane().add(InfoConfigPan, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // On affiche le solde du joueur sélectionné dans la JCB dans le jLabel associé.
    private void ListeJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeJActionPerformed
        this.jc = this.ljc.getJoueur(this.ListeJ.getSelectedIndex());
        this.JoueurSolde.setText("Solde de " + this.jc.getPseudo() + " : " + this.jc.getSolde() + " €");
    }//GEN-LAST:event_ListeJActionPerformed

    private void AcheterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcheterActionPerformed
        // On récupère le joueur sélectionné dans la JCB
        this.jc = this.ljc.getJoueur(this.ListeJ.getSelectedIndex());
        // Si le joueur à moins de 2 cartes
        if (this.jc.getMesCartes().getTaille() < 2) {
            if(this.jc.getSolde()!=0){
                // On appelle la méthode permettant d'acheter une carte et on actualise le jLabel
                jc.acheter(cc);
                this.JoueurSolde.setText("Solde de " + this.jc.getPseudo() + " : " + this.jc.getSolde() + " €");
                // On génère une nouvelle carte et on l'affiche.
                this.cc = new CarteLoto(this.nbCol, this.nbNum);
                afficheCarte();
            } else {
                JOptionPane.showMessageDialog(null, "Pas de solde", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            // On indique au joueur qu'il ne peut pas acheter + 2 cartes
        } else if (this.jc.getMesCartes().getTaille() == 2) {
            JOptionPane.showMessageDialog(null, "Vous avez déjà 2 cartes.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AcheterActionPerformed

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        // On regarde le nombre de cartes de chaque joueur.
        for (int i = 0; i < this.ljc.getNbJoueurs(); i++) {
            if (this.ljc.getJoueur(i).getMesCartes().getTaille() > 0) {
                // On met le boolean qui indique que chaque joueur à au moins une carte
                this.achat = true;
            } else {
                // On affiche quand un joueur n'a pas de carte.
                JOptionPane.showMessageDialog(null, this.ljc.getJoueur(i).getPseudo() + " n'a pas de cartes.", "Attention", JOptionPane.ERROR_MESSAGE);
                this.achat=false;
            }
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_FermerActionPerformed
    // On affiche une nouvelle carte
    private void AutreChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutreChoixActionPerformed
        this.cc = new CarteLoto(this.nbCol, this.nbNum);
        afficheCarte();
    }//GEN-LAST:event_AutreChoixActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acheter;
    private javax.swing.JButton AutreChoix;
    private javax.swing.JPanel ConfigMenuPan;
    private javax.swing.JButton Fermer;
    private javax.swing.JPanel InfoConfigPan;
    private javax.swing.JPanel InfoSoldePan;
    private javax.swing.JLabel JoueurSolde;
    private javax.swing.JComboBox<String> ListeJ;
    private javax.swing.JPanel PanTitre;
    private javax.swing.JPanel PanneauCarte;
    private javax.swing.JLabel Titre;
    // End of variables declaration//GEN-END:variables
}
