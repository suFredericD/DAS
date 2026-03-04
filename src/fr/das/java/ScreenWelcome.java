package fr.das.java;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScreenWelcome extends JFrame {

      public ScreenWelcome(Player player, House playerHouse) {
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
                        + "<h2 style ='font-family: Showcard Gothic, cursive; font-size: 28px; font-weight: bold; color: rgb(180, 102, 0); text-align: center; margin-top: 0px; padding-bottom: 20px;'>Arrakis Smuggler</h2>\n"
                        + "</div></html>\n";

            ImageIcon cover = new ImageIcon("DAS/src/fr/das/java/media/pics/accueil.png");
            JPanel headerPanel = new JPanel(new BorderLayout());
            headerPanel.setBackground(new Color(0, 0, 0));
            headerPanel.setLayout(new GridLayout(2, 1));
            headerPanel.add(new JLabel(cover), BorderLayout.NORTH);
            headerPanel.add(new JLabel(htmlHeader, SwingConstants.CENTER), BorderLayout.CENTER);

            String htmlWelcome = "<html><div>\n"
                        + "<p style ='text-align: center; font-family: Papyrus, cursive; font-size: 16px; color: rgb(148, 69, 16); background-color: black; padding-top: 40px; padding-left: 120px; padding-right: 120px;'>Une aventure de survie sur la planète Arrakis, dans l'univers de <u>Dune</u>.</p>\n"
                        + "<p style ='text-align: center; font-family: Papyrus, cursive; font-size: 12px; color: rgb(148, 69, 16); background-color: black; padding-top: 40px; padding-bottom: 40px; padding-left: 120px; padding-right: 120px;'>Maîtrise les secrets d'Arrakis, la planète-désert qui concentre toutes les tensions de l'univers connu.</p>\n"
                        + "</div>\n</html>\n";

            JButton characterButton = new JButton("Personnage");
            characterButton.setFont(new Font("Papyrus", Font.BOLD, 16));
            characterButton.setBackground(new Color(148, 69, 16));
            characterButton.setPreferredSize(new Dimension(0, 50));
            characterButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            characterButton.setFocusPainted(false);
            characterButton.setOpaque(true);
            characterButton.addActionListener(e -> {
                  new ScreenCharacter(player, playerHouse);
                  dispose();
            });

            JButton homeButton = new JButton("Domicile");
            homeButton.setFont(new Font("Papyrus", Font.BOLD, 16));
            homeButton.setBackground(new Color(148, 69, 16));
            homeButton.setPreferredSize(new Dimension(0, 50));
            homeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            homeButton.setFocusPainted(false);
            homeButton.setOpaque(true);
            homeButton.addActionListener(e -> {
                  new ScreenHome(player, playerHouse);
                  dispose();
            });

            JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
            buttonPanel.setBackground(new Color(0, 0, 0));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 120, 40, 120));
            buttonPanel.add(characterButton);
            buttonPanel.add(homeButton);

            JPanel welcomePanel = (JPanel) this.getContentPane();
            welcomePanel.setBackground(new Color(0, 0, 0));
            welcomePanel.add(headerPanel, BorderLayout.NORTH);
            welcomePanel.add(new JLabel(htmlWelcome, SwingConstants.CENTER), BorderLayout.CENTER);
            welcomePanel.add(buttonPanel, BorderLayout.SOUTH);

            System.out.println(
                        ConsoleColors.YELLOW + "Screen loaded : " + ConsoleColors.RESET + "Welcome\n");
      }
}