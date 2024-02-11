package BoiteDeDialogue;


import LesClasses.PanneauImage;
import LesClasses.Joueur;
import javax.swing.*;
import java.awt.*;

public class VisuJoueurDlg extends JDialog {

    // Attributs pour le joueur à visualiser et un PanneauImage pour l'affichage de sa photo
    private Joueur joueur;
    private PanneauImage pim;

    public VisuJoueurDlg(Frame parent, boolean modal, Joueur j) {
        //  On appelle le constructeur de la classe parente pour initialiser la JDialog.
        super(parent, modal);
        // On appelle les composants graphiques de l'interface de la JDialog.
        initComponents();
        // On initialise le joueur à afficher et le PanneauImage
        this.joueur = j;
        this.pim = new PanneauImage();
        // On appelle la méthode pour l'affichage des informations du joueur
        initInfos();
    }

    private void initInfos() {
        // On affiche la couleur du joueur dans le jPanel associé
        this.pseudoJoueur.setText(this.joueur.getPseudo());
        // On affiche la couleur du joueur dans le jPanel associé
        this.montantSolde.setText(Double.toString(this.joueur.getSolde()));
        // On affiche la couleur du joueur dans le jPanel associé
        this.panelCouleur.setBackground(this.joueur.getCouleur());
        // On initialise le texte de la zone d'édition pour afficher les informations sur le joueur
        this.Edition.setText(this.joueur.toString());
        // On affiche la photo du joueur
        this.pim.setImage(this.joueur.getPhoto().getImage());
        // On définit la taille du PanneauImage.
        this.pim.setPreferredSize(new Dimension(200, 200));
        // On ajoute le PanneauImage à l'interface
        this.photo.add(pim);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titrePanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        contenu = new javax.swing.JPanel();
        inforJoueur = new javax.swing.JPanel();
        titrePseudo = new javax.swing.JLabel();
        pseudoJoueur = new javax.swing.JTextField();
        titreCouleur = new javax.swing.JLabel();
        panelCouleur = new javax.swing.JPanel();
        titreSolde = new javax.swing.JLabel();
        montantSolde = new javax.swing.JTextField();
        texteInformations = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        photo = new javax.swing.JPanel();
        QuitMenu = new javax.swing.JPanel();
        Nothing = new javax.swing.JButton();
        Close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setMinimumSize(new java.awt.Dimension(600, 500));

        Title.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Title.setText("Informations relatives au joueur");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titrePanel.add(Title);

        getContentPane().add(titrePanel, java.awt.BorderLayout.NORTH);

        contenu.setLayout(new java.awt.BorderLayout());

        inforJoueur.setLayout(new java.awt.GridLayout(3, 2));

        titrePseudo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        titrePseudo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titrePseudo.setText("Pseudo :");
        inforJoueur.add(titrePseudo);

        pseudoJoueur.setEditable(false);
        pseudoJoueur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inforJoueur.add(pseudoJoueur);

        titreCouleur.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        titreCouleur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titreCouleur.setText("Couleur :");
        inforJoueur.add(titreCouleur);

        javax.swing.GroupLayout panelCouleurLayout = new javax.swing.GroupLayout(panelCouleur);
        panelCouleur.setLayout(panelCouleurLayout);
        panelCouleurLayout.setHorizontalGroup(
            panelCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCouleurLayout.setVerticalGroup(
            panelCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        inforJoueur.add(panelCouleur);

        titreSolde.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        titreSolde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titreSolde.setText("Solde :");
        inforJoueur.add(titreSolde);

        montantSolde.setEditable(false);
        montantSolde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inforJoueur.add(montantSolde);

        contenu.add(inforJoueur, java.awt.BorderLayout.CENTER);

        texteInformations.setLayout(new java.awt.BorderLayout());

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        texteInformations.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        contenu.add(texteInformations, java.awt.BorderLayout.SOUTH);
        contenu.add(photo, java.awt.BorderLayout.EAST);

        getContentPane().add(contenu, java.awt.BorderLayout.CENTER);

        QuitMenu.setLayout(new java.awt.GridLayout(1, 2));
        QuitMenu.add(Nothing);

        Close.setText("Fermer");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        QuitMenu.add(Close);

        getContentPane().add(QuitMenu, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // Fermeture de la fenêtre.
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JTextArea Edition;
    private javax.swing.JButton Nothing;
    private javax.swing.JPanel QuitMenu;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel contenu;
    private javax.swing.JPanel inforJoueur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField montantSolde;
    private javax.swing.JPanel panelCouleur;
    private javax.swing.JPanel photo;
    private javax.swing.JTextField pseudoJoueur;
    private javax.swing.JPanel texteInformations;
    private javax.swing.JLabel titreCouleur;
    private javax.swing.JPanel titrePanel;
    private javax.swing.JLabel titrePseudo;
    private javax.swing.JLabel titreSolde;
    // End of variables declaration//GEN-END:variables
}
