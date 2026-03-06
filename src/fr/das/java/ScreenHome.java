package fr.das.java;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScreenHome extends JFrame {
        public ScreenHome(Player player, House playerHouse) {
                String screenTitle = "Dune : Arrakis Smuggler - Domicile";
                int frameWidth = 800;
                int frameHeight = 800;
                setTitle(screenTitle);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setResizable(false);
                setVisible(true);
                Toolkit kit = Toolkit.getDefaultToolkit();
                Dimension screenSize = kit.getScreenSize();
                int width = screenSize.width;
                int height = screenSize.height;
                setBounds((width - frameWidth) / 2, (height - frameHeight) / 2, frameWidth, frameHeight);
                setBackground(new Color(0, 0, 0));

                add(createNorthPanel(player), BorderLayout.NORTH);
                add(createWestPanel(player), BorderLayout.WEST);
                add(createCenterPanel(player), BorderLayout.CENTER);
                // add(createEastPanel(player), BorderLayout.EAST);
                add(createSouthPanel(player, playerHouse), BorderLayout.SOUTH);

                System.out.println(
                                ConsoleColors.YELLOW + "Screen loaded : " + ConsoleColors.RESET + "Home\n");
        }

        // ==============================================================================
        // =================================================================== FONCTIONS
        // ==============================================================================
        public JPanel createCenterPanel(Player player) {
                JPanel centerPanel = new JPanel();
                centerPanel.setBackground(new Color(0, 0, 0));
                centerPanel.setLayout(new GridLayout(1, 1));
                ImageIcon cover = new ImageIcon("DAS/src/fr/das/java/media/pics/house.png");
                JLabel coverLabel = new JLabel(cover);
                coverLabel.setHorizontalAlignment(SwingConstants.CENTER);
                coverLabel.setVerticalAlignment(SwingConstants.CENTER);
                coverLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                centerPanel.add(coverLabel, SwingConstants.CENTER);
                return centerPanel;
        }

        public JPanel createSouthPanel(Player player, House playerHouse) {
                JButton welcomeButton = new JButton("Accueil");
                welcomeButton.setFont(new Font("Papyrus", Font.BOLD, 14));
                welcomeButton.setBackground(new Color(148, 69, 16));
                welcomeButton.setFocusPainted(false);
                welcomeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                welcomeButton.addActionListener(e -> {
                        new ScreenWelcome(player, playerHouse);
                        dispose();
                });

                JButton characterButton = new JButton("Personnage");
                characterButton.setFont(new Font("Papyrus", Font.BOLD, 16));
                characterButton.setBackground(new Color(148, 69, 16));
                characterButton.setPreferredSize(new Dimension(0, 50));
                characterButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                characterButton.setFocusPainted(false);
                characterButton.addActionListener(e -> {
                        new ScreenCharacter(player, playerHouse);
                        dispose();
                });

                JPanel buttonPanel = new JPanel();
                buttonPanel.setBackground(new Color(0, 0, 0));
                buttonPanel.setLayout(new GridLayout(1, 2, 20, 0));
                buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                buttonPanel.add(welcomeButton);
                buttonPanel.add(characterButton);
                return buttonPanel;
        }

        public JPanel createEastPanel(Player player) {
                JPanel eastPanel = new JPanel();
                eastPanel.setBackground(new Color(0, 0, 0));
                eastPanel.setLayout(new GridLayout(3, 1));
                eastPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                String htmlPhysicsLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Force</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px; '>"
                                + player.getStrength() + "</td></tr>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Endurance</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px; '>"
                                + player.getEndurance() + "</td></tr>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Agilité</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px; '>"
                                + player.getAgility() + "</td></tr>"
                                + "</table></html>";

                eastPanel.add(new JLabel(htmlPhysicsLabel, SwingConstants.CENTER));

                return eastPanel;
        }

        public JPanel createNorthPanel(Player player) {
                String htmlNameLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                + "<tr><td style=' border-color: #5f00ad; border-width: 2px; border-style: solid; color: #5f00ad; font-family: Papyrus; font-size: 24px; text-align: left; margin-left: 10px; margin-right: 10px; padding-top: 5px; padding-left: 10px; padding-right: 10px;'>"
                                + player.getHome().getName() + "</td>"
                                + "<td style=' border-color: #5f00ad; border-width: 2px; border-style: solid; color: #5f00ad; font-family: Papyrus; font-size: 24px; text-align: left; margin-left: 10px; margin-right: 10px; padding-top: 5px; padding-left: 10px; padding-right: 10px;'>"
                                + player.getHome().getLocation().getName() + "</td></tr>"
                                + "</table></html>";

                JPanel namePanel = new JPanel();
                namePanel.setBackground(new Color(0, 0, 0));
                namePanel.setLayout(new GridLayout(1, 1));
                namePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                namePanel.add(new JLabel(htmlNameLabel, SwingConstants.CENTER));

                return namePanel;
        }

        public JPanel createWestPanel(Player player) {
                String htmlSolariLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                + "<tr><td colspan='2' style='color: #9ea813; font-family: Papyrus; font-size: 10px; text-align: center; margin: 0; padding: 5px 0 10px 0;'>Solari</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: left; margin: 0; padding-right: 25px;'>Bourse</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 0;'>"
                                + player.getPurse() + "</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: left; margin: 0; padding-right: 25px;'>Coffre</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 0;'>"
                                + player.getHome().getVault() + "</td></tr>"
                                + "</table></html>";
                String htmlWaterLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #1977b6; border-width: 1px; border-style: solid;'>"
                                + "<tr><td style='color: #1977b6; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 0 5px 0;'>Réservoir</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 10px 0 10px;'>"
                                + player.getHome().getTankFill() + " / " + player.getHome().getTankCapacity()
                                + " ml</td></tr>"
                                + "<tr><td style='color: #1977b6; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 0 5px 0;'>Gourde</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 10px 0 10px;'>"
                                + player.getHome().getTankFill() + " / " + player.getHome().getTankCapacity()
                                + " ml</td></tr>"
                                + "</table></html>";

                JPanel levelsPanel = new JPanel();
                levelsPanel.setBackground(new Color(0, 0, 0));
                levelsPanel.setLayout(new GridLayout(2, 1, 10, 10));
                levelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                levelsPanel.add(new JLabel(htmlSolariLabel, SwingConstants.CENTER));
                levelsPanel.add(new JLabel(htmlWaterLabel, SwingConstants.CENTER));

                return levelsPanel;
        }
}