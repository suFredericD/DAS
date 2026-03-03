package fr.das.java;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScreenWelcome extends JFrame {

      public ScreenWelcome(Player player) {
            String screenTitle = "Dune : Arrakis Smuggler - Welcome Screen";
            int frameWidth = 800;
            int frameHeight = 800;

            setTitle(screenTitle);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension dimensionEcran = kit.getScreenSize();
            int largeur = dimensionEcran.width;
            int hauteur = dimensionEcran.height;
            setBounds((largeur - frameWidth) / 2, (hauteur - frameHeight) / 2, frameWidth, frameHeight);
            // setIconImage(kit.getImage("icone.gif"));

            String htmlHeader = "<html>"
                        + "<div style ='margin-top: 0px; padding-bottom: 100px; text-align: center; background-color: black;'>\n"
                        + "<h1 style ='font-family: Snap ITC, cursive; font-size: 58px; font-weight: bold; color: rgb(180, 102, 0);text-align: center; margin-top: 0px; margin-bottom: 0px; padding-top: 10px;'>DUNE</h1>\n"
                        + "<h2 style ='font-family: Showcard Gothic, cursive; font-size: 28px; font-weight: bold; color: rgb(70, 0, 128); text-align: center; margin-top: 0px; padding-bottom: 20px;'>Arrakis Smuggler</h2>\n"
                        + "</div></html>\n";

            JLabel headerLabel = new JLabel(htmlHeader, SwingConstants.CENTER);
            headerLabel.setSize(frameWidth, 100);
            headerLabel.setBackground(new Color(0, 0, 0));
            headerLabel.setOpaque(true);
            headerLabel.setBounds(0, 0, frameWidth, 300);

            String htmlWelcome = "<html><div>\n"
                        + "<p style ='text-align: center; font-family: Papyrus, cursive; font-size: 16px; color: rgb(148, 69, 16); background-color: black; padding-top: 40px; padding-left: 120px; padding-right: 120px;'>Une aventure de survie sur la planète Arrakis, dans l'univers de <u>Dune</u>.</p>\n"
                        + "<p style ='text-align: center; font-family: Papyrus, cursive; font-size: 12px; color: rgb(148, 69, 16); background-color: black; padding-top: 40px; padding-bottom: 40px; padding-left: 120px; padding-right: 120px;'>Maîtrise les secrets d'Arrakis, la planète-désert qui concentre toutes les tensions de l'univers connu.</p>\n"
                        + "</div>\n</html>\n";
            JLabel welcomeLabel = new JLabel(htmlWelcome, SwingConstants.CENTER);

            JButton characterButton = new JButton("Personnage");
            characterButton.setFont(new Font("Papyrus", Font.BOLD, 16));
            characterButton.setBackground(new Color(148, 69, 16));
            characterButton.setPreferredSize(new Dimension(0, 50));
            characterButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            characterButton.setFocusPainted(false);
            characterButton.setOpaque(true);
            characterButton.addActionListener(e -> {
                  new ScreenCharacter(player);
            });

            JPanel welcomePanel = (JPanel) this.getContentPane();
            welcomePanel.setBackground(new Color(0, 0, 0));

            welcomePanel.add(headerLabel, BorderLayout.NORTH);
            welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
            welcomePanel.add(characterButton, BorderLayout.SOUTH);
      }
}