
import BoiteDeDialogue.OptionDlg;
import LesClasses.CarteLoto;
import LesClasses.LesLots;
import LesClasses.LesJoueurs;
import LesClasses.Lot;
import LesClasses.Joueur;
import BoiteDeDialogue.AjoutLotDlg;
import BoiteDeDialogue.VisuJoueurDlg;
import BoiteDeDialogue.AchatCarteDlg;
import BoiteDeDialogue.SaisieJoueurDlg;
import BoiteDeDialogue.VisuLotsDlg;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class LeJeuLoto extends JFrame {

    // Attributs des listes des joueurs, des lots et des gagnants.
    private LesJoueurs listeJoueurs;
    private LesJoueurs gagnants;
    private LesLots lstL;
    // Attributs du lot et du joueur.
    private Lot lotEnJeu;
    private Joueur joueur;
    // Attributs des paramètres de la partie.
    private int option;
    private int nbCol, nbNum, nbLig;
    // Attributs du lancement de la partie.
    private boolean carteAchetee;
    private boolean optionConfigure;
    // Attributs du tableau des boules de tirage.
    private int boules[];
    private final int MAX = 90;
    // Stockage des boutons des joueurs.
    private ArrayList<JButton> ListeBoutonsJoueurs;

    public LeJeuLoto() {
        initComponents();
        // On initialise les variables des listes et des variables Joueur et Lot.
        this.listeJoueurs = new LesJoueurs();
        this.gagnants = new LesJoueurs();
        this.lstL = new LesLots();
        this.lotEnJeu = null;
        this.joueur = null;
        // On initialise le nombre de lignes avec celui du constructeur par défaut de la carte loto.
        this.nbLig = new CarteLoto().getNbLig();
        //On initialise le tableau des boules de 90 emplacements.
        this.boules = new int[MAX];
        // Méthode de remplissage du tableau des boules.
        initBoules();
        // Méthode pour l'ajout de deux joueurs.
        initJoueur();
        // Méthode d'ajout des lots.
        initLots();
        // On crée une liste contenant les boutons à droite de l'interface servant à visualiser les joueurs.
        this.ListeBoutonsJoueurs = new ArrayList<>(Arrays.asList(P1, P2, P3, P4));
    }

    // Méthode d'initialisation de deux joueurs.
    private void initJoueur() {
        Joueur Ellis = new Joueur("Ellis");
        Ellis.setSolde(100);
        Ellis.setCouleur(Color.red);
        Ellis.setPhoto(new ImageIcon(getClass().getResource("/LesImages/joueurDefaut.png")));
        this.listeJoueurs.ajouteJoueur(Ellis);
        this.P1.setBackground(Ellis.getCouleur());
        this.P1.setText(Ellis.getPseudo());
        Joueur Bob = new Joueur("Bob");
        Bob.setSolde(50);
        Bob.setCouleur(Color.blue);
        Bob.setPhoto(new ImageIcon(getClass().getResource("/LesImages/joueurDefaut.png")));
        this.listeJoueurs.ajouteJoueur(Bob);
        this.P2.setBackground(Bob.getCouleur());
        this.P2.setText(Bob.getPseudo());
    }

    // Méthode d'initialisation de lots.
    private void initLots() {
        Lot opinel = new Lot("Un Opinel");
        ImageIcon opinelIC = new ImageIcon(getClass().getResource("/LesImages/opinel.jpg"));
        opinel.setPicture(opinelIC);
        this.lstL.ajouteLot(opinel);
        Lot ps5 = new Lot("Une ps5");
        ImageIcon ps5IC = new ImageIcon(getClass().getResource("/LesImages/ps5.jpg"));
        ps5.setPicture(ps5IC);
        this.lstL.ajouteLot(ps5);
        Lot telescope = new Lot("Un télescope");
        ImageIcon telesIC = new ImageIcon(getClass().getResource("/LesImages/telescope.jpg"));
        telescope.setPicture(telesIC);
        this.lstL.ajouteLot(telescope);
        Lot corde = new Lot("Une corde à sauter");
        ImageIcon cordeIC = new ImageIcon(getClass().getResource("/LesImages/corde.jpg"));
        corde.setPicture(cordeIC);
        this.lstL.ajouteLot(corde);
        Lot cafe = new Lot("Une cafetière");
        ImageIcon cafeIC = new ImageIcon(getClass().getResource("/LesImages/cafetiere.jpg"));
        cafe.setPicture(cafeIC);
        this.lstL.ajouteLot(cafe);

    }

    // Méthode pour remplir de 0 le tableau de boules.
    private void initBoules() {
        for (int i = 0; i < MAX; i++) {
            this.boules[i] = 0;
        }
    }

    // Méthode pour l'affichage des cartes des joueurs.
    private void afficheCartes() {
        // Initialisation du compteur à 0.
        int compteur = 0;
        // On parcourt la liste des joueurs.
        for (int i = 0; i < this.listeJoueurs.getNbJoueurs(); i++) {
            // On regarde le nombre de cartes que possède le joueur.
            switch (this.listeJoueurs.getJoueur(i).getMesCartes().getTaille()) {
                // Si le joueur n'a aucune carte.
                case 0:
                    // On incrémente le compteur à 2.
                    compteur = 2;
                    break;
                // Si le joueur a une carte.
                case 1:
                    // On récupère le panneau correspondant au compteur actuel.
                    JPanel pan1 = (JPanel) this.LesCartons.getComponent(compteur);
                    // On dessine de la carte du joueur sur le panneau récupéré.
                    this.listeJoueurs.getJoueur(i).getMesCartes().getCarte(0).dessineCarte(pan1, this.listeJoueurs.getJoueur(i).getCouleur());
                    // On ajoute 2 au compteur pour passer au prochain panneau à construire (pour le prochain joueur).
                    compteur += 2;
                    break;
                // Si le joueur a deux cartes.
                case 2:
                    // On récupère du premier panneau correspondant au compteur actuel.
                    JPanel pan2 = (JPanel) this.LesCartons.getComponent(compteur);
                    // On dessine de la première carte du joueur sur le premier panneau récupéré.
                    this.listeJoueurs.getJoueur(i).getMesCartes().getCarte(0).dessineCarte(pan2, listeJoueurs.getJoueur(i).getCouleur());
                    // On augmente le compteur de 1 pour passer au prochain panneau.
                    compteur++;
                    // On récupère le deuxième panneau correspondant au compteur actuel.
                    JPanel pan3 = (JPanel) this.LesCartons.getComponent(compteur);
                    // On dessine de la deuxième carte du joueur sur le deuxième panneau récupéré.
                    this.listeJoueurs.getJoueur(i).getMesCartes().getCarte(1).dessineCarte(pan3, this.listeJoueurs.getJoueur(i).getCouleur());
                    // On ajoute 1 au compteur pour passer au prochain panneau (pour le prochain joueur).
                    compteur++;
                    break;
                default:
                    break;
            }
            // On redessine le composant. 
            pack();
            this.LesCartons.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LesCartons = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        Titre = new javax.swing.JLabel();
        panJoueur = new javax.swing.JPanel();
        P1 = new javax.swing.JButton();
        P2 = new javax.swing.JButton();
        P3 = new javax.swing.JButton();
        P4 = new javax.swing.JButton();
        PanTirageRecompense = new javax.swing.JPanel();
        recompense = new javax.swing.JLabel();
        Informations = new javax.swing.JPanel();
        Historique = new javax.swing.JLabel();
        ModeDeJeu = new javax.swing.JLabel();
        SPHistoriqueTirage = new javax.swing.JScrollPane();
        resultats = new javax.swing.JTextArea();
        TiragePanel = new javax.swing.JPanel();
        tirage = new javax.swing.JButton();
        valeur = new javax.swing.JLabel();
        arreter = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        AjoutMenu = new javax.swing.JMenu();
        Joueur = new javax.swing.JMenuItem();
        AjoutLot = new javax.swing.JMenuItem();
        VoirLots = new javax.swing.JMenuItem();
        Paramètres = new javax.swing.JMenu();
        achatCartes = new javax.swing.JMenuItem();
        demarrer = new javax.swing.JMenuItem();
        continuer = new javax.swing.JMenuItem();
        Recommencer = new javax.swing.JMenuItem();
        options = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(950, 520));

        LesCartons.setLayout(new java.awt.GridLayout(4, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        LesCartons.add(jPanel8);

        getContentPane().add(LesCartons, java.awt.BorderLayout.CENTER);

        Titre.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        Titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titre.setText("Le Jeu du Loto");
        getContentPane().add(Titre, java.awt.BorderLayout.NORTH);

        panJoueur.setLayout(new java.awt.GridLayout(4, 1));

        P1.setBorder(new javax.swing.border.MatteBorder(null));
        P1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        P1.setMaximumSize(new java.awt.Dimension(100, 100));
        P1.setMinimumSize(new java.awt.Dimension(100, 50));
        P1.setPreferredSize(new java.awt.Dimension(100, 50));
        P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1ActionPerformed(evt);
            }
        });
        panJoueur.add(P1);

        P2.setBorder(new javax.swing.border.MatteBorder(null));
        P2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        P2.setMaximumSize(new java.awt.Dimension(100, 100));
        P2.setMinimumSize(new java.awt.Dimension(100, 50));
        P2.setPreferredSize(new java.awt.Dimension(100, 50));
        P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2ActionPerformed(evt);
            }
        });
        panJoueur.add(P2);

        P3.setBorder(new javax.swing.border.MatteBorder(null));
        P3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        P3.setMaximumSize(new java.awt.Dimension(100, 100));
        P3.setMinimumSize(new java.awt.Dimension(100, 50));
        P3.setPreferredSize(new java.awt.Dimension(100, 50));
        P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P3ActionPerformed(evt);
            }
        });
        panJoueur.add(P3);

        P4.setBorder(new javax.swing.border.MatteBorder(null));
        P4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        P4.setMaximumSize(new java.awt.Dimension(100, 100));
        P4.setMinimumSize(new java.awt.Dimension(100, 50));
        P4.setPreferredSize(new java.awt.Dimension(100, 50));
        P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P4ActionPerformed(evt);
            }
        });
        panJoueur.add(P4);

        getContentPane().add(panJoueur, java.awt.BorderLayout.EAST);

        PanTirageRecompense.setMaximumSize(new java.awt.Dimension(200, 200));
        PanTirageRecompense.setMinimumSize(new java.awt.Dimension(200, 100));
        PanTirageRecompense.setPreferredSize(new java.awt.Dimension(200, 150));
        PanTirageRecompense.setLayout(new java.awt.BorderLayout());

        recompense.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        recompense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recompense.setText("Récompense ");
        recompense.setMaximumSize(new java.awt.Dimension(100, 10));
        recompense.setMinimumSize(new java.awt.Dimension(100, 10));
        recompense.setPreferredSize(new java.awt.Dimension(50, 30));
        recompense.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        PanTirageRecompense.add(recompense, java.awt.BorderLayout.NORTH);

        Informations.setPreferredSize(new java.awt.Dimension(488, 30));
        Informations.setLayout(new java.awt.GridLayout(2, 2));

        Historique.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Historique.setText("Historique du tirage des boules");
        Informations.add(Historique);

        ModeDeJeu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ModeDeJeu.setText("Option choisie : ");
        Informations.add(ModeDeJeu);

        resultats.setEditable(false);
        resultats.setColumns(20);
        resultats.setLineWrap(true);
        resultats.setRows(5);
        resultats.setMinimumSize(new java.awt.Dimension(250, 200));
        resultats.setPreferredSize(new java.awt.Dimension(250, 200));
        SPHistoriqueTirage.setViewportView(resultats);

        Informations.add(SPHistoriqueTirage);

        TiragePanel.setPreferredSize(new java.awt.Dimension(150, 100));
        TiragePanel.setLayout(new java.awt.GridLayout(1, 3));

        tirage.setText("Tirage");
        tirage.setEnabled(false);
        tirage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tirageActionPerformed(evt);
            }
        });
        TiragePanel.add(tirage);

        valeur.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        valeur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valeur.setText("N°");
        TiragePanel.add(valeur);

        arreter.setText("Arrêter le jeu");
        arreter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arreterActionPerformed(evt);
            }
        });
        TiragePanel.add(arreter);

        Informations.add(TiragePanel);

        PanTirageRecompense.add(Informations, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanTirageRecompense, java.awt.BorderLayout.SOUTH);

        AjoutMenu.setText("Ajout");

        Joueur.setText("Ajouter un Joueur");
        Joueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoueurActionPerformed(evt);
            }
        });
        AjoutMenu.add(Joueur);

        AjoutLot.setText("Ajouter un lot");
        AjoutLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutLotActionPerformed(evt);
            }
        });
        AjoutMenu.add(AjoutLot);

        VoirLots.setText("Voir les lots");
        VoirLots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoirLotsActionPerformed(evt);
            }
        });
        AjoutMenu.add(VoirLots);

        menuBar.add(AjoutMenu);

        Paramètres.setText("Action");

        achatCartes.setText("Acheter des cartes");
        achatCartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achatCartesActionPerformed(evt);
            }
        });
        Paramètres.add(achatCartes);

        demarrer.setText("Démarrer Jeu");
        demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demarrerActionPerformed(evt);
            }
        });
        Paramètres.add(demarrer);

        continuer.setText("Continuer");
        continuer.setEnabled(false);
        continuer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuerActionPerformed(evt);
            }
        });
        Paramètres.add(continuer);

        Recommencer.setText("Recommencer");
        Recommencer.setEnabled(false);
        Recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommencerActionPerformed(evt);
            }
        });
        Paramètres.add(Recommencer);

        options.setText("Options");
        options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsActionPerformed(evt);
            }
        });
        Paramètres.add(options);

        menuBar.add(Paramètres);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoueurActionPerformed
        // On ouvre une boite de dialogue pour la création d'un joueur.
        SaisieJoueurDlg diag = new SaisieJoueurDlg(this, true);
        diag.setVisible(true);
        // Si le renvoi des informations est autorisé.
        if (diag.getOk() == true) {
            // On récupère le nouveau joueur créé dans la JDialog.
            this.joueur = diag.getNouveauJoueur();
            // On regarde si le nombre maximum de joueurs est atteint.
            if (this.listeJoueurs.getNbJoueurs() > 3) {
                // On affiche un message d'erreur si le nombre maximum de joueurs est atteint.
                JOptionPane.showMessageDialog(null, "Nombre maximum de joueurs atteint.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                // Sinon on ajoute le nouveau joueur à la liste des joueurs.
                this.listeJoueurs.ajouteJoueur(this.joueur);
                // On initialise un boolean pour éviter l'édition de tous les boutons durant la boucle suivante.
                boolean BoutonVide = false;
                // On parcourt la liste de boutons de joueurs.
                for (JButton Bouton : ListeBoutonsJoueurs) {
                    // On regarde si le bouton est vide et qu'aucun bouton n'a été rempli auparavant.
                    if (Bouton.getText().equals("") && !BoutonVide) {
                        // On remplit le bouton avec le pseudo du joueur et définit sa couleur de fond.
                        Bouton.setText(this.joueur.getPseudo());
                        Bouton.setBackground(this.joueur.getCouleur());
                        // On met le booléen à true pour ne pas qu'il modifie tous les boutons.
                        BoutonVide = true;
                    }
                }
            }
        }

    }//GEN-LAST:event_JoueurActionPerformed

    private void P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1ActionPerformed
        // On regarde s'il y a au moyen 1 joueur dans la liste.
        if (this.listeJoueurs.getNbJoueurs() > 0) {
            // On récupère le premier joueur.
            this.joueur = this.listeJoueurs.getJoueur(0);
            // On ouvre une boite de dialogue permettant la visualisation du joueur.
            // On ajoute en paramètre le joueur récupéré.
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, this.joueur);
            diag.setVisible(true);
        } else {
            // On indique qu'il n'y a pas de joueur.
            JOptionPane.showMessageDialog(null, "Pas de joueur.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_P1ActionPerformed
    // Même procédé.
    private void P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2ActionPerformed
        // Au moins 2 joueurs.
        if (this.listeJoueurs.getNbJoueurs() > 1) {
            // On récupère le deuxième joueur.
            this.joueur = this.listeJoueurs.getJoueur(1);
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, this.joueur);
            diag.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pas de joueur.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_P2ActionPerformed
    // Même procédé.
    private void P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P3ActionPerformed
        // Au moins 3 joueurs.
        if (this.listeJoueurs.getNbJoueurs() > 2) {
            // On récupère le troisème joueur.
            this.joueur = this.listeJoueurs.getJoueur(2);
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, this.joueur);
            diag.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pas de joueur.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_P3ActionPerformed
    // Même procédé.
    private void P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P4ActionPerformed
        // Au moins 4 joueurs.
        if (this.listeJoueurs.getNbJoueurs() > 3) {
            // On récupère le quatrième joueur.
            this.joueur = this.listeJoueurs.getJoueur(3);
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, this.joueur);
            diag.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pas de joueur.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_P4ActionPerformed

    private void achatCartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achatCartesActionPerformed
        // S'il y a au moins deux joueurs, que les options sont configurées que les colonnes et les valeurs ne sont pas initialisées.
        if (this.listeJoueurs.getNbJoueurs() > 1 && this.optionConfigure) {
            // On ouvre la boite de dialogue pour acheter des cartes.
            // On ajoute en paramètre la liste des joueurs, le nombre de lignes, de colonnes et de valeurs.
            AchatCarteDlg diag = new AchatCarteDlg(this, true, this.listeJoueurs, this.nbLig, this.nbCol, this.nbNum);
            diag.setVisible(true);
            // On récupère le booléen indiquant que chaque joueur possède au moins une carte.
            this.carteAchetee = diag.isAchat();
            // On affiche les cartes des joueurs sur l'interface principale.
            afficheCartes();
            // Si les options ne sont pas configurées et qu'il n'y a pas de joueurs, on envoie un mesage.
        } else if (!this.optionConfigure) {
            JOptionPane.showMessageDialog(null, "Veuillez configurer les options", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Pas de joueurs.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_achatCartesActionPerformed

    private void optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsActionPerformed
        // On ouvre la boite de dialogue pour configurer les options.
        // On ajoute en paramètre le nombre de colonnes et le nombres de valeurs.
        OptionDlg diag = new OptionDlg(this, true);
        diag.setVisible(true);
        if (diag.isOk()) {
            // On récupère le nombre de colonnes, le mode de jeu et le nombre de valeurs initialisés dans la JDialog.
            this.nbCol = diag.getNbCol();
            this.nbNum = diag.getNbNum();
            this.option = diag.getChoixOpt();
            // On affiche le mode de jeu dans le jLabel associé en fonction de l'option choisie.
            switch (option) {
                case 1:
                    this.ModeDeJeu.setText("Option Choisie : Quinte");
                    break;
                case 2:
                    this.ModeDeJeu.setText("Option Choisie : Double Quine");
                    break;
                case 3:
                    this.ModeDeJeu.setText("Option Choisie : Carton plein");
                    break;
            }
            // On indique que les options du jeu sont faites.   
            this.optionConfigure = diag.isOk();
            this.options.setEnabled(false);
        }
    }//GEN-LAST:event_optionsActionPerformed

    private void demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demarrerActionPerformed
        // Il faut que tous les joueurs aient une carte, qu'il y ait au moins deux joueurs et un lot
        if (this.carteAchetee && this.listeJoueurs.getNbJoueurs() > 1 && this.lstL.getNbLots() > 0) {

            // On en tire un aléatoirement dans la liste et on l'ajoute au lot à gagner pour la partie.
            this.lotEnJeu = this.lstL.getLot((int) (Math.random() * this.lstL.getNbLots()));
            // On affiche le nom du lot sur jLabel associé.
            this.recompense.setText(this.lotEnJeu.toString());
            // Boutons activés
            this.tirage.setEnabled(true);

            this.Recommencer.setEnabled(true);
            // Boutons désactivés
            this.Joueur.setEnabled(false);
            this.AjoutLot.setEnabled(false);
            this.options.setEnabled(false);
            this.demarrer.setEnabled(false);
        } else if (this.lstL.getNbLots() < 0 && !carteAchetee) {
            // On indique à l'utilisateur qu'il n'a pas fini de configurer le jeu.
            JOptionPane.showMessageDialog(null, "Pas de lots en jeu.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Jeu non configuré.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_demarrerActionPerformed

    private void continuerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuerActionPerformed
        // On teste la configuration de l'option.
        switch (this.option) {
            // Cas de la Quinte.
            case 1:
                // S'il y a assez de lots.
                if (this.lstL.getNbLots() > 0) {
                    // On passe l'option à la Double Quinte.
                    this.option++;
                    // On vide la liste des gagnants.
                    this.gagnants.supprimeAll();
                    this.tirage.setEnabled(true);
                    this.demarrer.setEnabled(false);
                    this.Joueur.setEnabled(false);
                    this.AjoutLot.setEnabled(false);
                    this.ModeDeJeu.setText("Option Choisie : Double Quine");
                    // On en tire un aléatoirement dans la liste et on l'ajoute au lot à gagner pour la partie.
                    this.lotEnJeu = this.lstL.getLot((int) (Math.random() * this.lstL.getNbLots()));
                    // On affiche le nom du lot sur jLabel associé.
                    this.recompense.setText(this.lotEnJeu.toString());

                } else {
                    // Sinon, on met un message de l'absence de lots pour que l'utilisateur recommence la partie ou qu'il rajoute un lot.
                    JOptionPane.showMessageDialog(null, "Il n'y a plus de lots à gagner.", "Plus de lots", JOptionPane.ERROR_MESSAGE);
                }
                break;
            // Cas de la Double Quinte.
            case 2:
                if (this.lstL.getNbLots() > 0) {
                    // On passe l'option au Carton Plein.
                    this.option++;
                    this.gagnants.supprimeAll();
                    this.tirage.setEnabled(true);
                    this.demarrer.setEnabled(false);
                    this.Joueur.setEnabled(false);
                    this.AjoutLot.setEnabled(false);
                    this.ModeDeJeu.setText("Option Choisie : Carton plein");
                    // On en tire un aléatoirement dans la liste et on l'ajoute au lot à gagner pour la partie.
                    this.lotEnJeu = this.lstL.getLot((int) (Math.random() * this.lstL.getNbLots()));
                    // On affiche le nom du lot sur jLabel associé.
                    this.recompense.setText(this.lotEnJeu.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Il n'y a plus de lots à gagner.", "Plus de lots", JOptionPane.ERROR_MESSAGE);
                }
                break;
            // Cas du Carton plein.
            case 3:
                //On indique qu'il faut que l'utilisateur recommence la partie pour rejouer.
                JOptionPane.showMessageDialog(null, "Veuillez recommencer une partie.", "Partie finie", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_continuerActionPerformed

    private void AjoutLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutLotActionPerformed
        // On ouvre une boite de dialogue pour ajouter un lot à gagner.
        AjoutLotDlg diag = new AjoutLotDlg(this, true);
        diag.setVisible(true);
        // Si la condition de renvoi est vraie alors :
        if (diag.isOk()) {
            // On récupère le lot saisie dans la boite de dialogue.
            this.lotEnJeu = diag.getNouveauLot();
            // On l'ajoute à la liste des lots
            this.lstL.ajouteLot(this.lotEnJeu);
        }
    }//GEN-LAST:event_AjoutLotActionPerformed

    private void VoirLotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoirLotsActionPerformed
        // Ouverture d'une boite de dialogue permettant de voir les lots d'objets disponibles.
        // On ajoute en paramètre la liste des lots.
        VisuLotsDlg diag = new VisuLotsDlg(this, true, lstL);
        diag.setVisible(true);
    }//GEN-LAST:event_VoirLotsActionPerformed

    private void RecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommencerActionPerformed
        // On fait une boucle pour supprimer toutes les cartes de tous les joueurs.
        for (int i = 0; i < this.listeJoueurs.getNbJoueurs(); i++) {
            this.listeJoueurs.getJoueur(i).getMesCartes().supprimeAllCartes();
        }
        // On réinitialise l'affichage lié au lot et au tirage.
        this.jPanel1.removeAll();
        this.jPanel2.removeAll();
        this.jPanel3.removeAll();
        this.jPanel4.removeAll();
        this.jPanel5.removeAll();
        this.jPanel6.removeAll();
        this.jPanel7.removeAll();
        this.jPanel8.removeAll();;
        this.resultats.setText("");
        this.valeur.setText("N° : " + "");
        this.recompense.setText("Récompense");
        initBoules();
        // On supprime les gagnants
        this.gagnants.supprimeAll();
        //On remet les boutons à leur état original.
        this.Joueur.setEnabled(true);
        this.AjoutLot.setEnabled(true);
        this.demarrer.setEnabled(true);
        this.achatCartes.setEnabled(true);
        this.options.setEnabled(true);
        this.continuer.setEnabled(false);
        this.Recommencer.setEnabled(false);
        this.tirage.setEnabled(false);
        this.options.setEnabled(true);
        // On vide le contenu des variables des colonnes, de l'option et du nombre de valeurs pour la prochaine partie.
        this.nbCol = 0;
        this.nbNum = 0;
        this.option = 1;
        this.optionConfigure=false;
        this.carteAchetee=false;
        // On redessine l'interface.
        pack();
        repaint();
    }//GEN-LAST:event_RecommencerActionPerformed

    private void arreterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arreterActionPerformed
        JOptionPane.showMessageDialog(null, "Fin de la partie", "Partie finie", JOptionPane.INFORMATION_MESSAGE);
        // On vide le contenu des variables des colonnes, de l'option et du nombre de valeurs pour la prochaine partie.
        this.nbCol = 0;
        this.nbNum = 0;
        this.option = 1;
        for (int i = 0; i < this.listeJoueurs.getNbJoueurs(); i++) {
            this.listeJoueurs.supprimeAll();
        }
        // On réinitialise l'affichage lié au lot et au tirage.
        this.jPanel1.removeAll();
        this.jPanel2.removeAll();
        this.jPanel3.removeAll();
        this.jPanel4.removeAll();
        this.jPanel5.removeAll();
        this.jPanel6.removeAll();
        this.jPanel7.removeAll();
        this.jPanel8.removeAll();
        this.resultats.setText("");
        this.valeur.setText("N° : " + "");
        this.recompense.setText("Récompense");
        this.ModeDeJeu.setText("Option choisie : ");
        // On supprime les gagnants
        this.gagnants.supprimeAll();
        //On remet les boutons à leur état original.
        this.Joueur.setEnabled(true);
        this.AjoutLot.setEnabled(true);
        this.demarrer.setEnabled(true);
        this.achatCartes.setEnabled(true);
        this.options.setEnabled(true);
        this.continuer.setEnabled(false);
        this.Recommencer.setEnabled(false);
        this.tirage.setEnabled(false);
        // On vide les boutons des joueurs
        for (int i = 0; i < this.ListeBoutonsJoueurs.size(); i++) {
            this.ListeBoutonsJoueurs.get(i).setBackground(null);
            this.ListeBoutonsJoueurs.get(i).setText("");
        }
        // On remet le tableau des boules de tirage à 0
        initBoules();
        // On actualise l'interface
        pack();
        repaint();
    }//GEN-LAST:event_arreterActionPerformed

    private void tirageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tirageActionPerformed
        int nb;
        // On tire un nombre aléatoire entre 1 et 90 tout en vérifiant s'il n'a pas déjà été tiré.
        do {
            nb = (int) (Math.random() * 90) + 1;
        } while (this.boules[nb - 1] != 0);
        // On affiche la valeur dans le jLabel associé.
        this.valeur.setText("" + nb);
        // On l'affiche dans la zone de texte pour l'historique.
        this.resultats.append("" + nb + " ; ");
        // On parcourt la liste des joueurs.
        for (int i = 0; i < this.listeJoueurs.getNbJoueurs(); i++) {
            // On parcourt la liste des cartes de chaque joueur.
            for (int j = 0; j < this.listeJoueurs.getJoueur(i).getMesCartes().getTaille(); j++) {
                // On regarde si la valeur tiré est dans la carte.
                if (this.listeJoueurs.getJoueur(i).getMesCartes().getCarte(j).estDans(nb)) {
                    // Si elle l'est, on place un jetons qui colorie la case de la valeur en blanc.
                    this.listeJoueurs.getJoueur(i).getMesCartes().getCarte(j).placePion(nb);
                    // On regarde si le joueur est gagnant selon les conditions de victoire de la partie.
                    if (this.listeJoueurs.getJoueur(i).getMesCartes().getCarte(j).cartonGagnant(this.option)) {
                        // Si il a gagné, on l'ajoute dans la liste des gagnants.
                        this.gagnants.ajouteJoueur(this.listeJoueurs.getJoueur(i));
                        // S'il y a plusieurs gagnants, on tire au sort parmi la liste et on affiche le gagnant.
                        if (this.gagnants.getNbJoueurs() > 1) {
                            JOptionPane.showMessageDialog(null, "Plusieurs personnes ont gagnés : tirage au sorts", "Plusieurs gagnants", JOptionPane.INFORMATION_MESSAGE);
                            // On récupère le gagnant dans une variable.
                            this.joueur = this.gagnants.getJoueur((int) (Math.random() * this.gagnants.getNbJoueurs()));
                            // on affiche un message de victoire.
                            JOptionPane.showMessageDialog(null, this.joueur.getPseudo() + " a gagné", "Bravo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // On récupère le gagnant dans une variable.
                            this.joueur = this.gagnants.getJoueur(0);
                            // on affiche un message de victoire.
                            JOptionPane.showMessageDialog(null, this.listeJoueurs.getJoueur(i).getPseudo() + " a gagné", "Bravo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        // On ajoute le lot au gagnant.
                        this.joueur.getMesLots().ajouteLot(lotEnJeu);
                        // On supprime le lot de la liste.
                        this.lstL.supprimeLot(lotEnJeu);
                        // On désactice les boutons pour tirer.
                        this.tirage.setEnabled(false);
                        // On active les boutons nécessaires
                        this.continuer.setEnabled(true);
                        this.AjoutLot.setEnabled(true);
                    }
                    // On actualise les cartes.
                    afficheCartes();
                }
            }
        }
    }//GEN-LAST:event_tirageActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LeJeuLoto().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AjoutLot;
    private javax.swing.JMenu AjoutMenu;
    private javax.swing.JLabel Historique;
    private javax.swing.JPanel Informations;
    private javax.swing.JMenuItem Joueur;
    private javax.swing.JPanel LesCartons;
    private javax.swing.JLabel ModeDeJeu;
    private javax.swing.JButton P1;
    private javax.swing.JButton P2;
    private javax.swing.JButton P3;
    private javax.swing.JButton P4;
    private javax.swing.JPanel PanTirageRecompense;
    private javax.swing.JMenu Paramètres;
    private javax.swing.JMenuItem Recommencer;
    private javax.swing.JScrollPane SPHistoriqueTirage;
    private javax.swing.JPanel TiragePanel;
    private javax.swing.JLabel Titre;
    private javax.swing.JMenuItem VoirLots;
    private javax.swing.JMenuItem achatCartes;
    private javax.swing.JButton arreter;
    private javax.swing.JMenuItem continuer;
    private javax.swing.JMenuItem demarrer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem options;
    private javax.swing.JPanel panJoueur;
    private javax.swing.JLabel recompense;
    private javax.swing.JTextArea resultats;
    private javax.swing.JButton tirage;
    private javax.swing.JLabel valeur;
    // End of variables declaration//GEN-END:variables
}
