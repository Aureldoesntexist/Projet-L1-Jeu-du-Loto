package BoiteDeDialogue;


import LesClasses.PanneauImage;
import LesClasses.Lot;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AjoutLotDlg extends javax.swing.JDialog {

    // Attributs pour le lot que l'on crée, pour l'affichage de son image et un booléen pour renvoyer ou non les informations.
    private Lot nouveauLot;
    private boolean ok;
    private PanneauImage pim;
    // Attributs si c'est un lot de type bon d'achat ou un objet.
    private JButton parcourir;
    private JComboBox<Integer> listeBon;

    public AjoutLotDlg(Frame parent, boolean modal) {
        //  On appelle le constructeur de la classe parente pour initialiser la JDialog.
        super(parent, modal);
        // On appelle les composants graphiques de l'interface de la JDialog.
        initComponents();
        // On initialise le nouveau Lot, le PanneauImage et la liste déroulante<;
        this.nouveauLot = new Lot();
        this.listeBon = new JComboBox<>();
        this.pim = new PanneauImage();
        // On sélectionne l'option d'objet par défaut.
        this.objet.setSelected(true);
        // On appelle la méthode associée.
        radioObjet();

    }

    // Accesseur pour le lot et le booléen 
    public Lot getNouveauLot() {
        return this.nouveauLot;
    }

    public boolean isOk() {
        return this.ok;
    }

    private void radioObjet() {
        // Vérifie si le bouton radio "objet" est sélectionné
        if (this.objet.isSelected()) {
            // On initialise le PanneauImage
            this.pim = new PanneauImage();
            // On initialise un bouton.
            this.parcourir = new JButton();
            // On efface tous les composants des deux derniers Panel du GriLayout.
            this.panImLabel.removeAll();
            this.parJCB.removeAll();
            // On ajoute le PanneauImage à son jPanel prévu pour l'affichage .
            this.panImLabel.add(this.pim, BorderLayout.CENTER);
            // On définit sa taille par rapport au jPanel associé
            this.pim.setPreferredSize(new Dimension(200, 200));
            // On ajoute le nouveau bouton au jPanel associé.
            this.parJCB.add(parcourir, BorderLayout.CENTER);
            // On définit la taille du bouton "parcourir".
            this.parcourir.setPreferredSize(new Dimension(200, 150));
            // On ajoute du texte sur le bouton.
            this.parcourir.setText("Parcourir");
            // Ajoute un écouteur d'évènement au bouton pour récupérer une image dans les fichiers de l'utilisateur.
            this.parcourir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // On crée un nouveau JFileChooser.
                    JFileChooser fileChooser = new JFileChooser();
                    // On ouvre la boîte de dialogue pour sélectionner un fichier.
                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        // On récupère le chemin du fichier sélectionné.
                        String nfc = fileChooser.getSelectedFile().getPath();
                        // On définit l'image sélectionnée dans le PanneauImage.
                        pim.setImage(Toolkit.getDefaultToolkit().getImage(nfc));
                    }
                }
            });
            // Redimensionne la fenêtre pour s'adapter aux nouveaux composants
            pack();
            // Redessine la fenêtre pour afficher les nouveaux composants
            repaint();
        }
    }

    public void radioBonAchat() {
        // On vide la JComboBox
        this.listeBon.removeAllItems();
        // On vide le composant prévu à l'ajout de la JComboBox et celui pour le jLabel.
        this.panImLabel.removeAll();
        this.parJCB.removeAll();
        // On crée le jLabel et on l'ajoute à son jPanel associé avec une définition de sa taille
        JLabel titre = new JLabel("Montant du bon d'achat");
        this.panImLabel.add(titre);
        titre.setPreferredSize(new Dimension(200, 100));
        // On remplit la JComboBox
        this.listeBon.addItem(10);
        this.listeBon.addItem(30);
        this.listeBon.addItem(50);
        this.listeBon.addItem(100);
        //On l'ajoute au jPanel associé et on définit sa taille
        this.parJCB.add(this.listeBon);
        this.listeBon.setPreferredSize(new Dimension(200, 100));
        // On redessine les composants
        pack();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupeCategorie = new javax.swing.ButtonGroup();
        ConfigLot = new javax.swing.JPanel();
        descriptif = new javax.swing.JLabel();
        TFdescriptif = new javax.swing.JTextField();
        catégorie = new javax.swing.JLabel();
        ObjetBon = new javax.swing.JPanel();
        bonAchat = new javax.swing.JRadioButton();
        objet = new javax.swing.JRadioButton();
        panImLabel = new javax.swing.JPanel();
        parJCB = new javax.swing.JPanel();
        PanTitre = new javax.swing.JPanel();
        Titre = new javax.swing.JLabel();
        boutons = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));

        ConfigLot.setLayout(new java.awt.GridLayout(3, 2));

        descriptif.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        descriptif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptif.setText("Descriptif");
        ConfigLot.add(descriptif);
        ConfigLot.add(TFdescriptif);

        catégorie.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        catégorie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        catégorie.setText("Catégorie");
        ConfigLot.add(catégorie);

        ObjetBon.setLayout(new java.awt.GridLayout(1, 0));

        groupeCategorie.add(bonAchat);
        bonAchat.setText("Bon d'achat");
        bonAchat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bonAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonAchatActionPerformed(evt);
            }
        });
        ObjetBon.add(bonAchat);

        groupeCategorie.add(objet);
        objet.setText("Objet");
        objet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        objet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetActionPerformed(evt);
            }
        });
        ObjetBon.add(objet);

        ConfigLot.add(ObjetBon);
        ConfigLot.add(panImLabel);
        ConfigLot.add(parJCB);

        getContentPane().add(ConfigLot, java.awt.BorderLayout.CENTER);

        PanTitre.setLayout(new java.awt.BorderLayout());

        Titre.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titre.setText("Ajout d'un nouveau lot");
        PanTitre.add(Titre, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanTitre, java.awt.BorderLayout.NORTH);

        boutons.setLayout(new java.awt.GridLayout(1, 0));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        boutons.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        boutons.add(Valider);

        getContentPane().add(boutons, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // On récupère le texte saisi pour le descriptif/nom.
        String nouveauNom = this.TFdescriptif.getText();
        // On ajoute le nom au lot créé.
        this.nouveauLot.setDescriptif(nouveauNom);
        if (this.objet.isSelected()) {
            // On met un montant à 0.
            this.nouveauLot.setMontant(0);
            // On ajoute l'image au lot créé.
            this.nouveauLot.setPicture(new ImageIcon(this.pim.getImage()));
        } else {
            // On ajoute juste le montant si c'est un bont d'achat.
            this.nouveauLot.setMontant(Integer.parseInt(this.listeBon.getSelectedItem().toString()));
        }
        // Booleen à true pour le renvoi des informations et fermeture de la fenêtre.
        this.ok = true;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ValiderActionPerformed

    private void objetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetActionPerformed
        // Appel de la méthode pour l'affichage des composants si c'est un objet.
        radioObjet();
    }//GEN-LAST:event_objetActionPerformed

    private void bonAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonAchatActionPerformed
        // Appel de la méthode pour l'affichage des composants si c'est un bon d'achat
        radioBonAchat();
    }//GEN-LAST:event_bonAchatActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // On indique qu'il y a pas de renvoi des informations et on ferme la fenêtre.
        this.ok = false;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JPanel ConfigLot;
    private javax.swing.JPanel ObjetBon;
    private javax.swing.JPanel PanTitre;
    private javax.swing.JTextField TFdescriptif;
    private javax.swing.JLabel Titre;
    private javax.swing.JButton Valider;
    private javax.swing.JRadioButton bonAchat;
    private javax.swing.JPanel boutons;
    private javax.swing.JLabel catégorie;
    private javax.swing.JLabel descriptif;
    private javax.swing.ButtonGroup groupeCategorie;
    private javax.swing.JRadioButton objet;
    private javax.swing.JPanel panImLabel;
    private javax.swing.JPanel parJCB;
    // End of variables declaration//GEN-END:variables
}
