package BoiteDeDialogue;


import javax.swing.*;

public class OptionDlg extends JDialog {

    private int nbCol;
    private int nbNum;
    private int choixOpt;
    private boolean ok;

    // Valide quand les options sont configurées
    public boolean isOk() {
        return this.ok;
    }

    // Accesseurs
    public int getNbCol() {
        return this.nbCol;
    }

    public int getNbNum() {
        return this.nbNum;
    }

    public int getChoixOpt() {
        return this.choixOpt;
    }

    public OptionDlg(java.awt.Frame parent, boolean modal) {
        //  On appelle le constructeur de la classe parente pour initialiser la JDialog.
        super(parent, modal);
        // On appelle les composants graphiques de l'interface de la JDialog.
        initComponents();
        // On présélectionne l'option
        this.choixOpt = 1;
        this.Quinte.setSelected(true);
        remplirComboCol();
    }

    // On remplit la JCB de numéro entre 5 et 9.
    private void remplirComboCol() {
        for (int i = 5; i <= 9; i++) {
            this.ComboNbCol.addItem(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGroup = new javax.swing.ButtonGroup();
        CTitre = new javax.swing.JPanel();
        Titre = new javax.swing.JLabel();
        MenuVA = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        Container = new javax.swing.JPanel();
        ModeJeu = new javax.swing.JPanel();
        TModeJeu = new javax.swing.JPanel();
        TChoix = new javax.swing.JLabel();
        Quinte = new javax.swing.JRadioButton();
        DoubleQuinte = new javax.swing.JRadioButton();
        CartonPlein = new javax.swing.JRadioButton();
        ContainerConfig = new javax.swing.JPanel();
        Info = new javax.swing.JLabel();
        Vide = new javax.swing.JPanel();
        Config = new javax.swing.JPanel();
        NumCol = new javax.swing.JLabel();
        ComboNbCol = new javax.swing.JComboBox<>();
        TNum = new javax.swing.JLabel();
        TFNum = new javax.swing.JTextField();
        Message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setResizable(false);

        Titre.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Titre.setText("Options du jeu");
        CTitre.add(Titre);

        getContentPane().add(CTitre, java.awt.BorderLayout.NORTH);

        MenuVA.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        MenuVA.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        MenuVA.add(Valider);

        getContentPane().add(MenuVA, java.awt.BorderLayout.SOUTH);

        Container.setLayout(new java.awt.GridLayout(1, 2));

        ModeJeu.setPreferredSize(new java.awt.Dimension(50, 80));
        ModeJeu.setLayout(new java.awt.GridLayout(4, 1));

        TModeJeu.setAlignmentX(50.0F);
        TModeJeu.setAlignmentY(50.0F);
        TModeJeu.setLayout(new java.awt.BorderLayout());

        TChoix.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TChoix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TChoix.setText("Comment voulez-vous jouer ?");
        TChoix.setFocusable(false);
        TChoix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TModeJeu.add(TChoix, java.awt.BorderLayout.CENTER);

        ModeJeu.add(TModeJeu);

        BGroup.add(Quinte);
        Quinte.setText("Quinte");
        Quinte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Quinte.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ModeJeu.add(Quinte);

        BGroup.add(DoubleQuinte);
        DoubleQuinte.setText("Double Quinte");
        DoubleQuinte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DoubleQuinte.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ModeJeu.add(DoubleQuinte);

        BGroup.add(CartonPlein);
        CartonPlein.setText("Carton plein");
        CartonPlein.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CartonPlein.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ModeJeu.add(CartonPlein);

        Container.add(ModeJeu);

        ContainerConfig.setLayout(new java.awt.GridLayout(4, 1));

        Info.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Info.setText("Configuration des cartons");
        ContainerConfig.add(Info);
        ContainerConfig.add(Vide);

        Config.setLayout(new java.awt.GridLayout(3, 2));

        NumCol.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        NumCol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumCol.setText("Combien de colonnes ?");
        Config.add(NumCol);

        Config.add(ComboNbCol);

        TNum.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        TNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TNum.setText("Combien de numéros ?");
        Config.add(TNum);
        Config.add(TFNum);

        ContainerConfig.add(Config);

        Message.setFocusable(false);
        Message.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ContainerConfig.add(Message);

        Container.add(ContainerConfig);

        getContentPane().add(Container, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // On récupère le choix selon le bouton radio sélectionné.
        if (this.Quinte.isSelected()) {
            this.choixOpt = 1;
        } else if (this.DoubleQuinte.isSelected()) {
            this.choixOpt = 2;
        } else {
            this.choixOpt = 3;
        }
        // On récupère le nombre sélectionné de colonnes dans la JCB.
        this.nbCol = Integer.parseInt(this.ComboNbCol.getSelectedItem().toString());
        // On récupère la saisie pour le nombre de valeurs
        String strNbNum = this.TFNum.getText();
        // On regarde si la saisie est vide.
        if (strNbNum.isEmpty()) {
            this.Message.setText("Veuillez saisir un nombre de numéros");
        } else {
            //On la convertit en entier.
            this.nbNum = Integer.parseInt(strNbNum);
            // Si elle ne remplit pas les conditions, on affiche un message
            if (this.nbNum < 5 || this.nbNum > this.nbCol * 3) {
                this.Message.setText("Le nombre de numéros doit être compris entre 5 et 3 fois le nombre de colonnes");
            } else {
                // Fermeture de la fenêtre et booléen pour le renvoi des informations
                this.setVisible(false);
                this.dispose();
                this.ok = true;
            }

        }
    }//GEN-LAST:event_ValiderActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // Fermeture de la fenêtre et booléen pour empêcher le renvoi des informations
        this.ok = false;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.ButtonGroup BGroup;
    private javax.swing.JPanel CTitre;
    private javax.swing.JRadioButton CartonPlein;
    private javax.swing.JComboBox<Integer> ComboNbCol;
    private javax.swing.JPanel Config;
    private javax.swing.JPanel Container;
    private javax.swing.JPanel ContainerConfig;
    private javax.swing.JRadioButton DoubleQuinte;
    private javax.swing.JLabel Info;
    private javax.swing.JPanel MenuVA;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel ModeJeu;
    private javax.swing.JLabel NumCol;
    private javax.swing.JRadioButton Quinte;
    private javax.swing.JLabel TChoix;
    private javax.swing.JTextField TFNum;
    private javax.swing.JPanel TModeJeu;
    private javax.swing.JLabel TNum;
    private javax.swing.JLabel Titre;
    private javax.swing.JButton Valider;
    private javax.swing.JPanel Vide;
    // End of variables declaration//GEN-END:variables
}
