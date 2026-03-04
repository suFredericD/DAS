package fr.das.java;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScreenCharacter extends JFrame {
        public ScreenCharacter(Player player) {
                String screenTitle = "Dune : Arrakis Smuggler - Personnage";
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

                add(createNorthPanel(player), BorderLayout.NORTH);
                add(createWestPanel(player), BorderLayout.WEST);
                add(createEastPanel(player), BorderLayout.EAST);
                add(createSouthPanel(player), BorderLayout.SOUTH);
                add(createCenterPanel(player), BorderLayout.CENTER);

                System.out.println(
                                ConsoleColors.YELLOW + "Screen loaded : " + ConsoleColors.RESET + "Character\n");
        }

        // ==============================================================================
        // =================================================================== FONCTIONS
        // ==============================================================================
        public JPanel createCenterPanel(Player player) {
                JPanel centerPanel = new JPanel();
                centerPanel.setBackground(new Color(0, 0, 0));
                centerPanel.setLayout(new GridLayout(1, 1));
                String htmlCharacterDrawLabel = "<html>"
                                + ""
                                + "</html>";

                centerPanel.add(new JLabel(htmlCharacterDrawLabel, SwingConstants.CENTER));
                return centerPanel;
        }

        public JPanel createSouthPanel(Player player) {
                JButton welcomeButton = new JButton("Accueil");
                welcomeButton.setFont(new Font("Papyrus", Font.BOLD, 14));
                welcomeButton.setBackground(new Color(148, 69, 16));
                welcomeButton.setFocusPainted(false);
                welcomeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                welcomeButton.addActionListener(e -> {
                        new ScreenWelcome(player);
                });

                JPanel buttonPanel = new JPanel();
                buttonPanel.setBackground(new Color(0, 0, 0));
                buttonPanel.add(welcomeButton);
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
                String htmlMentalsLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Intelligence</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px; '>"
                                + player.getIntelligence() + "</td></tr>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Charisme</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px;'>"
                                + player.getCharisma() + "</td></tr>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Chance</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px;'>"
                                + player.getLuck() + "</td></tr>"
                                + "</table></html>";
                String htmlBattleLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Attaque</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px;'>"
                                + player.getAttack() + "</td></tr>"
                                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Défense</td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: right; margin: 0; padding: 5px;'>"
                                + player.getDefense() + "</td></tr>"
                                + "</table></html>";
                eastPanel.add(new JLabel(htmlPhysicsLabel, SwingConstants.CENTER));
                eastPanel.add(new JLabel(htmlMentalsLabel, SwingConstants.CENTER));
                eastPanel.add(new JLabel(htmlBattleLabel, SwingConstants.CENTER));
                return eastPanel;
        }

        public JPanel createNorthPanel(Player player) {
                String htmlNameLabel = "<html>"
                                + "<h1 style=' border-color: #5f00ad; border-width: 2px; border-style: solid; color: #5f00ad; font-family: Papyrus; font-size: 24px; text-align: left; margin-left: 10px; margin-right: 10px; padding-top: 5px; padding-left: 10px; padding-right: 10px;'>"
                                + player.getName() + " " + player.getLastName() + "</h1></html>";
                String htmlLocationLabel = "<html>"
                                + "<h2 style='border-color: #944510; border-width: 1px; border-style: solid; color: #944510; font-family: Papyrus; font-size: 14px; text-align: center; margin: 0; padding-left: 10px; padding-right: 10px;'>"
                                + player.getHome().getLocation().getName() + "</h2></html>";

                JPanel namePanel = new JPanel();
                namePanel.setBackground(new Color(0, 0, 0));
                namePanel.setLayout(new GridLayout(1, 1));
                namePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                namePanel.add(new JLabel(htmlNameLabel, SwingConstants.CENTER));
                namePanel.add(new JLabel(htmlLocationLabel, SwingConstants.CENTER));
                return namePanel;
        }

        public JPanel createWestPanel(Player player) {
                String htmlLevelsLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                + "<tr><td colspan='2' style='color: #944510; font-family: Papyrus; font-size: 14px; text-align: center; margin: 0; padding: 0;'>"
                                + player.getFaction().getName() + "</td></tr>"
                                + "<tr><td style='color: #944510; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 10px;'>Niveau : </td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: left; margin: 0; padding: 0;'>"
                                + player.getLevel()
                                + "</td></tr>"
                                + "<tr><td style='color: #9ea813; font-family: Papyrus; font-size: 10px; text-align: center; margin: 0; padding: 10px;'>Solaris : </td>"
                                + "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: left; margin: 0; padding: 0;'>"
                                + player.getPurse()
                                + "</td></tr></table></html>";
                String htmlHealthLabel = "<html><table style='margin: 0; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                +
                                "<tr><td style='color: #941010; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Santé</td></tr><tr>"
                                +
                                "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>"
                                + player.getHealth() + " / " + player.getMaxHealth()
                                + "</td></tr></table></html>";

                String htmlThirstLabel = "<html><table style='margin: 0; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                +
                                "<tr><td style='color: #1977b6; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Soif</td></tr><tr>"
                                +
                                "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>"
                                + player.getThirst() + " / " + player.getMaxThirst()
                                + "</td></tr></table></html>";
                String htmlStaminaLabel = "<html><table style='margin: 0; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                                +
                                "<tr><td style='color: #0e941a; font-family: Papyrus; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>Endurance</td></tr><tr>"
                                +
                                "<td style='color: #944510; font-family: Consolas; font-size: 12px; text-align: center; margin: 0; padding: 5px; '>"
                                + player.getStamina() + " / " + player.getMaxStamina()
                                + "</td></tr></table></html>";

                JPanel levelsPanel = new JPanel();
                levelsPanel.setBackground(new Color(0, 0, 0));
                levelsPanel.setLayout(new GridLayout(4, 1, 10, 10));
                levelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                levelsPanel.add(new JLabel(htmlLevelsLabel, SwingConstants.CENTER));
                levelsPanel.add(new JLabel(htmlHealthLabel, SwingConstants.CENTER));
                levelsPanel.add(new JLabel(htmlThirstLabel, SwingConstants.CENTER));
                levelsPanel.add(new JLabel(htmlStaminaLabel, SwingConstants.CENTER));

                return levelsPanel;
        }
}