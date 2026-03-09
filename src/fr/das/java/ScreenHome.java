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
                int frameWidth = 960;
                int frameHeight = 960;
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
                add(createWestPanel(player, playerHouse), BorderLayout.WEST);
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
                welcomeButton.addActionListener(e -> {
                        new ScreenWelcome(player, playerHouse);
                        dispose();
                });

                JButton characterButton = new JButton("Personnage");
                characterButton.setFont(new Font("Papyrus", Font.BOLD, 16));
                characterButton.setBackground(new Color(148, 69, 16));
                characterButton.setPreferredSize(new Dimension(0, 50));
                characterButton.setFocusPainted(false);
                characterButton.addActionListener(e -> {
                        new ScreenCharacter(player, playerHouse);
                        dispose();
                });
                JButton activitiesButton = new JButton("Activités");
                activitiesButton.setFont(new Font("Papyrus", Font.BOLD, 16));
                activitiesButton.setBackground(new Color(148, 69, 16));
                activitiesButton.setPreferredSize(new Dimension(0, 50));
                activitiesButton.setFocusPainted(false);
                activitiesButton.setOpaque(true);
                activitiesButton.addActionListener(e -> {
                        new ScreenSelectActionType(player, playerHouse);
                        dispose();
                });
                JPanel buttonPanel = new JPanel();
                buttonPanel.setBackground(new Color(0, 0, 0));
                buttonPanel.setLayout(new GridLayout(1, 2, 20, 0));
                buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                buttonPanel.add(welcomeButton);
                buttonPanel.add(characterButton);
                buttonPanel.add(activitiesButton);
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

        public JPanel createWestPanel(Player player, House playerHouse) {
                String htmlSolariLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                + "<tr><td colspan='2' style='color: #9ea813; font-family: Papyrus; font-size: 10px; text-align: center; margin: 0; padding: 5px 0 10px 0;'>Solari</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: left; margin: 0; padding-right: 25px;'>Bourse</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 0;'>"
                                + player.getPurse() + "</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: left; margin: 0; padding-right: 25px;'>Coffre</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 0;'>"
                                + player.getHome().getVault() + "</td></tr>"
                                + "</table></html>";
                String htmlWaterLabel = "<html><table style='margin: 10px; padding: 5px;'>"
                                + "<tr><td style='color: #1977b6; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 0 5px 0;'>Réservoir</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 10px 0 10px;'>"
                                + player.getHome().getTankFill() + " / " + player.getHome().getTankCapacity()
                                + " ml</td></tr>"
                                + "<tr><td style='color: rgb(25, 119, 182); font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 0 5px 0;'>Gourde</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 0 10px 0 10px;'>"
                                + player.getJolitreFill() + " / " + player.getJolitre()
                                + " ml</td></tr>"
                                + "</table></html>";

                JButton putWaterButton = new JButton("Déposer (100 ml)");
                putWaterButton.setFont(new Font("Consolas", Font.BOLD, 12));
                putWaterButton.setBackground(new Color(25, 119, 182));
                putWaterButton.setPreferredSize(new Dimension(0, 20));
                putWaterButton.setFocusPainted(false);
                putWaterButton.setOpaque(true);
                putWaterButton.addActionListener(e -> {
                        if (player.getJolitreFill() >= 100) {
                                if (playerHouse.getTankFill() <= (playerHouse.getTankCapacity() - 100)) {
                                        player.setJolitreFill(player.getJolitreFill() - 100);
                                        playerHouse.setTankFill(playerHouse.getTankFill() + 100);
                                }
                        }
                        new ScreenHome(player, playerHouse);
                        dispose();
                });
                JButton getWaterButton = new JButton("Prélever (100 ml)");
                getWaterButton.setFont(new Font("Consolas", Font.BOLD, 12));
                getWaterButton.setBackground(new Color(25, 119, 182));
                getWaterButton.setPreferredSize(new Dimension(0, 20));
                getWaterButton.setFocusPainted(false);
                getWaterButton.setOpaque(true);
                getWaterButton.addActionListener(e -> {
                        if (playerHouse.getTankFill() > 100) {
                                if (player.getJolitreFill() <= (player.getJolitre() - 100)) {
                                        player.setJolitreFill(player.getJolitreFill() + 100);
                                        playerHouse.setTankFill(playerHouse.getTankFill() - 100);
                                }
                        }
                        new ScreenHome(player, playerHouse);
                        dispose();
                });
                JPanel waterPanel = new JPanel();
                waterPanel.setBackground(new Color(0, 0, 0));
                waterPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                waterPanel.setLayout(new GridLayout(3, 1, 10, 10));
                JLabel waterStatusLabel = new JLabel(htmlWaterLabel, SwingConstants.CENTER);

                waterPanel.add(waterStatusLabel);
                waterPanel.add(putWaterButton);
                waterPanel.add(getWaterButton);

                JPanel levelsPanel = new JPanel();
                levelsPanel.setBackground(new Color(0, 0, 0));
                levelsPanel.setLayout(new GridLayout(2, 1, 10, 20));
                levelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                levelsPanel.add(new JLabel(htmlSolariLabel, SwingConstants.CENTER));
                levelsPanel.add(waterPanel);

                return levelsPanel;
        }
}