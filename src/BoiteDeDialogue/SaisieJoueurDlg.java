package BoiteDeDialogue;


import LesClasses.PanneauImage;
import LesClasses.Joueur;
import java.awt.*;
import javax.swing.*;

public class SaisieJoueurDlg extends JDialog {

    // Attributs pour le joueur que l'on crée, pour l'affichage de son image et un booléen pour renvoyer ou non les informations.
    private Joueur nouveauJoueur;
    private PanneauImage pim;
    private boolean ok;

    public SaisieJoueurDlg(Frame parent, boolean modal) {
        // On appelle le constructeur de la classe parente pour initialiser la JDialog.
        super(parent, modal);
        // On appelle les composants graphiques de l'interface de la JDialog.
        initComponents();
        // Initialisation des variables pour le PanneauImage et le nouveau joueur. 
        this.pim = new PanneauImage();
        this.nouveauJoueur = new Joueur();
    }

    // Accesseur pour le joueur et le booléen 
    public Joueur getNouveauJoueur() {
        return nouveauJoueur;
    }

    public boolean getOk() {
        return ok;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titrePanneau = new javax.swing.JPanel();
        titre = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        titrePseudo = new javax.swing.JLabel();
        pseudoJoueur = new javax.swing.JTextField();
        titreSolde = new javax.swing.JLabel();
        montantSolde = new javax.swing.JTextField();
        titreCouleur = new javax.swing.JLabel();
        contenuCouleur = new javax.swing.JPanel();
        selectionCouleur = new javax.swing.JButton();
        panneauCouleur = new javax.swing.JPanel();
        titrePhoto = new javax.swing.JLabel();
        contenuPhoto = new javax.swing.JPanel();
        Parcourir = new javax.swing.JButton();
        BPhoto = new javax.swing.JPanel();
        Button = new javax.swing.JPanel();
        Close = new javax.swing.JButton();
        Submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titre.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        titre.setText("Ajout d'un nouveau joueur");
        titrePanneau.add(titre);

        getContentPane().add(titrePanneau, java.awt.BorderLayout.NORTH);

        contenu.setLayout(new java.awt.GridLayout(4, 2));

        titrePseudo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        titrePseudo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titrePseudo.setText("Pseudo ?");
        titrePseudo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        contenu.add(titrePseudo);
        contenu.add(pseudoJoueur);

        titreSolde.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        titreSolde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titreSolde.setText("Solde ?");
        contenu.add(titreSolde);
        contenu.add(montantSolde);

        titreCouleur.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        titreCouleur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titreCouleur.setText("Couleur ?");
        contenu.add(titreCouleur);

        contenuCouleur.setLayout(new java.awt.GridLayout(1, 0));

        selectionCouleur.setText("Cliquez !");
        selectionCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionCouleurActionPerformed(evt);
            }
        });
        contenuCouleur.add(selectionCouleur);

        javax.swing.GroupLayout panneauCouleurLayout = new javax.swing.GroupLayout(panneauCouleur);
        panneauCouleur.setLayout(panneauCouleurLayout);
        panneauCouleurLayout.setHorizontalGroup(
            panneauCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        panneauCouleurLayout.setVerticalGroup(
            panneauCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        contenuCouleur.add(panneauCouleur);

        contenu.add(contenuCouleur);

        titrePhoto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        titrePhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titrePhoto.setText("Photo ?");
        titrePhoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        contenu.add(titrePhoto);

        contenuPhoto.setLayout(new java.awt.GridLayout(1, 2));

        Parcourir.setText("Parcourir");
        Parcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParcourirActionPerformed(evt);
            }
        });
        contenuPhoto.add(Parcourir);

        javax.swing.GroupLayout BPhotoLayout = new javax.swing.GroupLayout(BPhoto);
        BPhoto.setLayout(BPhotoLayout);
        BPhotoLayout.setHorizontalGroup(
            BPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        BPhotoLayout.setVerticalGroup(
            BPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        contenuPhoto.add(BPhoto);

        contenu.add(contenuPhoto);

        getContentPane().add(contenu, java.awt.BorderLayout.CENTER);

        Button.setLayout(new java.awt.GridLayout(1, 2));

        Close.setText("Fermer");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        Button.add(Close);

        Submit.setText("Valider");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        Button.add(Submit);

        getContentPane().add(Button, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // Récupération et convertion du solde et du pseudo pour le nouveau joueur pour le renvoi dans l'application principale
        String nouveauPseudo = this.pseudoJoueur.getText();
        String nouveauSolde = this.montantSolde.getText();
        double convertNouveauSolde = Double.parseDouble(nouveauSolde);
        this.nouveauJoueur.setPseudo(nouveauPseudo);
        this.nouveauJoueur.setSolde(convertNouveauSolde);
        // Booleen à true pour le renvoi des informations et fermeture de la fenêtre.
        this.ok = true;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_SubmitActionPerformed

    private void selectionCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionCouleurActionPerformed
        // Ouverture de la boite de dialogue de sélection de couleur
        // Couleur par défaut est le fait et on récupère la couleur.
        Color color = JColorChooser.showDialog(this, "Couleur", Color.green);
        // Si une couleur est choisi ou qu'il y a toujours celle par défaut alors :
        if (color != null) {
            // On ajoute la couleur aux données du joueur.
            this.nouveauJoueur.setCouleur(color);
            // On ajoute la couleur dans le JPanel de l'interface de Saisie prévu à cet effet.
            this.panneauCouleur.setBackground(color);
        }
    }//GEN-LAST:event_selectionCouleurActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // On indique qu'il y a pas de renvoi des informations et on ferme la fenêtre.
        this.ok = false;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void ParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParcourirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // On récupère le chemin de l'image sélectionnée
            String chemin = fileChooser.getSelectedFile().getPath();
            // On récupère l'image dans une variable.
            Image image = (new ImageIcon(chemin).getImage());
            // On met l'image sur le PanneauImage.
            this.pim.setImage(image);
            // On redimensionne le PanneauImage
            this.pim.setPreferredSize(new Dimension(200, 150));
            // On ajoute le PanneauImage contenant l'image sélectionné dans le JPanel prévu à cet effet et on paramètre le layout
            this.BPhoto.setLayout(new BorderLayout());
            this.BPhoto.add(this.pim, BorderLayout.CENTER);
            // On ajoute l'image aux données.
            this.nouveauJoueur.setPhoto(new ImageIcon(chemin));
        }
        pack();
        // On redessinne le composant.
        this.BPhoto.repaint();
    }//GEN-LAST:event_ParcourirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BPhoto;
    private javax.swing.JPanel Button;
    private javax.swing.JButton Close;
    private javax.swing.JButton Parcourir;
    private javax.swing.JButton Submit;
    private javax.swing.JPanel contenu;
    private javax.swing.JPanel contenuCouleur;
    private javax.swing.JPanel contenuPhoto;
    private javax.swing.JTextField montantSolde;
    private javax.swing.JPanel panneauCouleur;
    private javax.swing.JTextField pseudoJoueur;
    private javax.swing.JButton selectionCouleur;
    private javax.swing.JLabel titre;
    private javax.swing.JLabel titreCouleur;
    private javax.swing.JPanel titrePanneau;
    private javax.swing.JLabel titrePhoto;
    private javax.swing.JLabel titrePseudo;
    private javax.swing.JLabel titreSolde;
    // End of variables declaration//GEN-END:variables

}
