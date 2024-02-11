package BoiteDeDialogue;
import LesClasses.PanneauImage;
import LesClasses.LesLots;
import java.awt.*;
import javax.swing.*;

public class VisuLotsDlg extends JDialog {

    // Attributs pour la liste des lots et d'un PanneauImage pour l'affichage.
    private LesLots lots;
    private PanneauImage pim;

    public VisuLotsDlg(Frame parent, boolean modal, LesLots lots) {
        //  On appelle le constructeur de la classe parente pour initialiser la JDialog.
        super(parent, modal);
        // On appelle les composants graphiques de l'interface de la JDialog.
        initComponents();
        // On initialise la liste des lots avec la liste en paramètre.
        this.lots = lots;
        // On appelle la méthode pour l'affichage des lots.
        initLot();
    }

    private void initLot() {
        // On vide le composant.
        this.PanPhotos.removeAll();
        // On met le layout sur le JPanel.
        this.PanPhotos.setLayout(new GridLayout(0, 3));
        // On parcourt la liste des lots.
        for (int i = 0; i < this.lots.getNbLots(); i++) {
            // Si c'est une image
            if (lots.getLot(i).getPicture() != null) {
                // On crée un JPanel.
                JPanel ImageP = new JPanel();
                // On initialise le PanneauImage.
                this.pim = new PanneauImage();
                // On met l'image du lot sur le PanneauImage.
                this.pim.setImage(this.lots.getLot(i).getPicture().getImage());
                // On met une taille de préférence
                this.pim.setPreferredSize(new Dimension(200, 200));
                // On ajoute ça au jPanel créé qui permet d'éviter la déformation des images.
                ImageP.add(pim);
                // On ajoute ça au jPanel principal.
                this.PanPhotos.add(ImageP);
            } else {
                // Si c'est un bon d'achat, on ajoute son nom et son montant dans la JComboBox.
                this.bonAchat.addItem(this.lots.getLot(i).getDescriptif() + " de " + this.lots.getLot(i).getMontant() + "€");
            }
        }
        // On redessine le composant.
        pack();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanTitre = new javax.swing.JPanel();
        titre = new javax.swing.JLabel();
        PanPhotos = new javax.swing.JPanel();
        bouton = new javax.swing.JPanel();
        fermer = new javax.swing.JButton();
        jcbBonAchat = new javax.swing.JPanel();
        bonAchat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        PanTitre.setLayout(new java.awt.BorderLayout());

        titre.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titre.setText("Visualisation des lots");
        titre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titre.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        PanTitre.add(titre, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanTitre, java.awt.BorderLayout.NORTH);
        getContentPane().add(PanPhotos, java.awt.BorderLayout.CENTER);

        bouton.setLayout(new java.awt.BorderLayout());

        fermer.setText("Fermer");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });
        bouton.add(fermer, java.awt.BorderLayout.CENTER);

        getContentPane().add(bouton, java.awt.BorderLayout.SOUTH);

        jcbBonAchat.add(bonAchat);

        getContentPane().add(jcbBonAchat, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        // Fermeture de la fenêtre.
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_fermerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanPhotos;
    private javax.swing.JPanel PanTitre;
    private javax.swing.JComboBox<String> bonAchat;
    private javax.swing.JPanel bouton;
    private javax.swing.JButton fermer;
    private javax.swing.JPanel jcbBonAchat;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables
}
