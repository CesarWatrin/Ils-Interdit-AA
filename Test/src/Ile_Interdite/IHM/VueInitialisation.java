/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ile_Interdite.IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author watrinc
 */
public class VueInitialisation extends Observe {

    private JFrame fenetre;
    private JTextField nom1, nom2, nom3, nom4;
    private JLabel joueur1, joueur2, joueur3, joueur4;
    private String J1, J2, J3, J4;
    private JComboBox choixPremierJoueur;
    private final Font policeTitre = new Font(Font.DIALOG, Font.BOLD, 80);
    private final Font policeLabel = new Font(Font.MONOSPACED, Font.BOLD, 30);
    private final Font diff = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private int val;

    public VueInitialisation() {
        fenetre = new JFrame("Ile Interdite Initialisation");
        J1 = "Navigateur";
        J2 = "Explorateur";
        J3 = "Ingenieur";
        J4 = "Pilot";
        //////////////////////////////////////////////////////TITRE////////////////////////////////////////////////////////////
        JPanel panelTitre = new JPanel();

        JLabel titre = new JLabel("Ile Interdite");
        titre.setFont(policeTitre);
        panelTitre.add(titre);

        fenetre.add(panelTitre, BorderLayout.NORTH);
        //////////////////////////////////////////////////////TITRE//////////////////////////////////////////////////////////// 

        //////////////////////////////////////////////////////VALEURS//////////////////////////////////////////////////////////  
        JPanel panelValeurs = new JPanel(new GridLayout(5, 2));

        JLabel nb = new JLabel("Nombre de joueurs : ");
        nb.setFont(diff);
        choixPremierJoueur = new JComboBox(new Integer[]{2, 3, 4});
        choixPremierJoueur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((int) choixPremierJoueur.getSelectedItem() == 2) {
                    nom3.setEnabled(false);
                    nom4.setEnabled(false);
                    joueur3.setEnabled(false);
                    joueur4.setEnabled(false);
                }
                if ((int) choixPremierJoueur.getSelectedItem() == 3) {
                    nom1.setEnabled(true);
                    nom2.setEnabled(true);
                    nom3.setEnabled(true);
                    joueur1.setEnabled(true);
                    joueur2.setEnabled(true);
                    joueur3.setEnabled(true);
                    nom4.setEnabled(false);
                    joueur4.setEnabled(false);
                }
                if ((int) choixPremierJoueur.getSelectedItem() == 4) {
                    nom1.setEnabled(true);
                    nom2.setEnabled(true);
                    nom3.setEnabled(true);
                    nom4.setEnabled(true);
                    joueur1.setEnabled(true);
                    joueur2.setEnabled(true);
                    joueur3.setEnabled(true);
                    joueur4.setEnabled(true);
                }
            }
        });

        joueur1 = new JLabel("Joueur 1 : ");
        joueur1.setFont(policeLabel);
        joueur1.setForeground(Color.RED);
        joueur2 = new JLabel("Joueur 2 : ");
        joueur2.setFont(policeLabel);
        joueur2.setForeground(Color.BLUE);
        joueur3 = new JLabel("Joueur 3 : ");
        joueur3.setFont(policeLabel);
        joueur3.setForeground(Color.GREEN);
        joueur3.setEnabled(false);
        joueur4 = new JLabel("Joueur 4 : ");
        joueur4.setFont(policeLabel);
        joueur4.setForeground(Color.MAGENTA);
        joueur4.setEnabled(false);

        nom1 = new JTextField();
        nom1.setFont(policeLabel);
        nom1.setEnabled(true);
        nom2 = new JTextField();
        nom2.setFont(policeLabel);
        nom2.setEnabled(true);
        nom3 = new JTextField();
        nom3.setFont(policeLabel);
        nom3.setEnabled(false);
        nom4 = new JTextField();
        nom4.setFont(policeLabel);
        nom4.setEnabled(false);

        panelValeurs.add(nb);
        panelValeurs.add(choixPremierJoueur);
        panelValeurs.add(joueur1);
        panelValeurs.add(nom1);
        panelValeurs.add(joueur2);
        panelValeurs.add(nom2);
        panelValeurs.add(joueur3);
        panelValeurs.add(nom3);
        panelValeurs.add(joueur4);
        panelValeurs.add(nom4);

        fenetre.add(panelValeurs);
        //////////////////////////////////////////////////////VALEURS//////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////LANCER////////////////////////////////////////////////////////////
        JPanel panelLancer = new JPanel(new GridLayout(3, 1));

        JLabel difficulte = new JLabel("Choix de la difficulté : ");
        difficulte.setFont(diff);
        JSlider choixDifficulte = new JSlider(SwingConstants.HORIZONTAL, 1, 4, 1);
        choixDifficulte.setPaintLabels(true);
        choixDifficulte.setPaintTicks(true);
        choixDifficulte.setMajorTickSpacing(1);
        choixDifficulte.setMinorTickSpacing(1);
        choixDifficulte.setFont(diff);
        choixDifficulte.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                val = choixDifficulte.getValue();
            }
        });

        JButton commencer = new JButton(" Commencer ");
        commencer.setFont(diff);
        commencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String no1 = nom1.getText();
                String no2 = nom2.getText();
                String no3 = nom3.getText();
                String no4 = nom4.getText();

                if (no1.isEmpty() && no2.isEmpty() && no3.isEmpty() && no4.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText("Joueur 2");
                    nom3.setText("Joueur 3");
                    nom4.setText("Joueur 4");
                } else if (no1.isEmpty() && no2.isEmpty() && no3.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText("Joueur 2");
                    nom3.setText("Joueur 3");
                    nom4.setText(no4);
                } else if (no2.isEmpty() && no3.isEmpty() && no4.isEmpty()) {
                    nom1.setText(no1);
                    nom2.setText("Joueur 2");
                    nom3.setText("Joueur 3");
                    nom4.setText("Joueur 4");
                } else if (no1.isEmpty() && no2.isEmpty() && no4.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText("Joueur 2");
                    nom3.setText(no3);
                    nom4.setText("Joueur 4");
                } else if (no1.isEmpty() && no3.isEmpty() && no4.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText(no2);
                    nom3.setText("Joueur 3");
                    nom4.setText("Joueur 4");
                } else if (no1.isEmpty() && no2.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText("Joueur 2");
                    nom3.setText(no3);
                    nom4.setText(no4);
                } else if (no1.isEmpty() && no3.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText(no2);
                    nom3.setText("Joueur 3");
                    nom4.setText(no4);
                } else if (no1.isEmpty() && no4.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText(no2);
                    nom3.setText(no3);
                    nom4.setText("Joueur 4");
                } else if (no2.isEmpty() && no3.isEmpty()) {
                    nom1.setText(no1);
                    nom2.setText("Joueur 2");
                    nom3.setText("Joueur 3");
                    nom4.setText(no4);
                } else if (no2.isEmpty() && no4.isEmpty()) {
                    nom1.setText(no1);
                    nom2.setText("Joueur 2");
                    nom3.setText(no3);
                    nom4.setText("Joueur 4");
                } else if (no3.isEmpty() && no4.isEmpty()) {
                    nom1.setText(no1);
                    nom2.setText(no2);
                    nom3.setText("Joueur 3");
                    nom4.setText("Joueur 4");
                } else if (no1.isEmpty()) {
                    nom1.setText("Joueur 1");
                    nom2.setText(no2);
                    nom3.setText(no3);
                    nom4.setText(no4);
                } else if (no2.isEmpty()) {
                    nom1.setText(no1);
                    nom2.setText("Joueur 2");
                    nom3.setText(no3);
                    nom4.setText(no4);
                } else if (no3.isEmpty()) {
                    nom1.setText(no1);
                    nom2.setText(no2);
                    nom3.setText("Joueur 3");
                    nom4.setText(no4);
                } else if (no4.isEmpty()) {
                    nom1.setText(no1);
                    nom2.setText(no2);
                    nom3.setText(no3);
                    nom4.setText("Joueur 4");
                } else {
                    nom1.setText(no1);
                    nom2.setText(no2);
                    nom3.setText(no3);
                    nom4.setText(no4);
                }

                String nno1 = nom1.getText();
                String nno2 = nom2.getText();
                String nno3 = nom3.getText();
                String nno4 = nom4.getText();
                
               
                
                int difficulte = val;

                Message m = new Message();
                m.type = TypesMessages.DEMARRER_PARTIE;
                m.nbJoueurs = (int) choixPremierJoueur.getSelectedItem();
                m.nom1 = nno1;
                m.nom2 = nno2;
                m.nom3 = nno3;
                m.nom4 = nno4;
                m.difficulte = difficulte;
                notifierObservateur(m);
            }
        });

        panelLancer.add(difficulte);
        panelLancer.add(choixDifficulte);
        panelLancer.add(commencer);

        fenetre.add(panelLancer, BorderLayout.SOUTH);
        //////////////////////////////////////////////////////LANCER////////////////////////////////////////////////////////////
    }

    public void afficher() {
        //permet d'afficher la fenetre d'initialisation
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(800, 500);
        fenetre.setVisible(true);
    }

    public void demarrerJeu() {
        fenetre.setVisible(false);
    }

}
