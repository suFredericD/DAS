package fr.das.java;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScreenSelectActionType extends JFrame {
    public ScreenSelectActionType(Player player, House playerHouse) {
        String screenTitle = "Dune : Arrakis Smuggler - Choirsir une activité";
        int frameWidth = 1024;
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

        add(createNorthPanel(player), BorderLayout.NORTH);
        add(createWestPanel(player), BorderLayout.WEST);
        add(createEastPanel(player), BorderLayout.EAST);
        add(createSouthPanel(player, playerHouse), BorderLayout.SOUTH);
        add(createCenterPanel(player), BorderLayout.CENTER);

        System.out.println(
                ConsoleColors.YELLOW + "Screen loaded : " + ConsoleColors.RESET + "Activities\n");
    }
    // ==============================================================================
    // =================================================================== FONCTIONS
    // ==============================================================================

    public JPanel createCenterPanel(Player player) {
        String htmlWorkLabel = "<html>"
                + "Production"
                + "Repos"
                + "Social"
                + "Exploration"
                + "</html>";

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(0, 0, 0));
        centerPanel.setLayout(new GridLayout(3, 2));
        centerPanel.add(createProductionPanel());
        return centerPanel;
    }

    public JPanel createProductionPanel() {
        String htmlProductionTtitleLabel = "<html><table style='font-family: Papyrus; color : rgb(148, 69, 16); border: 1px; border-color : rgb(148, 69, 16);'>"
                + "<tr><td style='font-size: 14px; text-align: center;'>Production</td></tr>"
                + "<tr><td style='font-size: 10px; text-align: center;'>Les activités de production sont fatiguantes mais rapporte un petit bonus supplémentaire</td></tr>"
                + "</table></html>";
        JLabel productionTitleLabel = new JLabel(htmlProductionTtitleLabel, SwingConstants.CENTER);
        productionTitleLabel.setBackground(new Color(0, 0, 0));
        productionTitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String htmlSpiceTitleLabel = "<html><table style='font-family: Papyrus; color : rgb(148, 69, 16); border: 1px; border-color : rgb(148, 69, 16);'>"
                + "<tr><td style='font-size: 12px; text-align: center;'>Moissonner l'Epice</td></tr>"
                + "</table></html>";
        JLabel spiceTitleLabel = new JLabel(htmlSpiceTitleLabel, SwingConstants.CENTER);
        spiceTitleLabel.setBackground(new Color(0, 0, 0));
        spiceTitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton harvestButton = new JButton("Moissonner");
        harvestButton.setFont(new Font("Papyrus", Font.BOLD, 14));
        harvestButton.setBackground(new Color(148, 69, 16));
        harvestButton.setFocusPainted(false);
        harvestButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        harvestButton.addActionListener(e -> {
            dispose();
        });

        String htmlHuaniTitleLabel = "<html><table style='font-family: Papyrus; color : rgb(148, 69, 16); border: 1px; border-color : rgb(148, 69, 16);'>"
                + "<tr><td style='font-size: 12px; text-align: center;'>Récolter de l'eau</td></tr>"
                + "</table></html>";
        JLabel huaniTitleLabel = new JLabel(htmlHuaniTitleLabel, SwingConstants.CENTER);
        huaniTitleLabel.setBackground(new Color(0, 0, 0));
        huaniTitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton collectButton = new JButton("Récolter");
        collectButton.setFont(new Font("Papyrus", Font.BOLD, 14));
        collectButton.setBackground(new Color(148, 69, 16));
        collectButton.setFocusPainted(false);
        collectButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        collectButton.addActionListener(e -> {
            dispose();
        });

        JPanel productionPanel = new JPanel();
        productionPanel.setBackground(new Color(0, 0, 0));
        productionPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // productionTitleLabel : première ligne, occupe 2 colonnes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        productionPanel.add(productionTitleLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        productionPanel.add(spiceTitleLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        productionPanel.add(harvestButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        productionPanel.add(huaniTitleLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        productionPanel.add(collectButton, gbc);
        return productionPanel;
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

        JPanel southPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        southPanel.setBackground(new Color(0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        southPanel.add(welcomeButton);
        southPanel.add(characterButton);
        southPanel.add(homeButton);
        return southPanel;
    }

    public JPanel createEastPanel(Player player) {
        String htmlLabel = "";
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(new Color(0, 0, 0));
        eastPanel.setLayout(new GridLayout(1, 1));
        eastPanel.add(new JLabel(htmlLabel, SwingConstants.CENTER));
        return eastPanel;
    }

    public JPanel createNorthPanel(Player player) {
        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        String gameHourLabel = "";
        if (player.getGameHour() < 13) {
            gameHourLabel = player.getGameHour() + ": 00 am";
        } else {
            gameHourLabel = player.getGameHour() + ": 00 pm";
        }
        String htmlNameLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                + "<tr><td style='color: #5f00ad; font-family: Papyrus; font-size: 28px; text-align: left; margin-left: 10px; margin-right: 10px; padding: 5px 10px 0 10px;'>"
                + player.getName() + " " + player.getLastName() + "</td></tr></table></html>";
        String htmlLocationLabel = "<html><table style='margin: 10px; padding: 5px; border-color: #944510; border-width: 1px; border-style: solid;'>"
                + "<tr><td style='border-color: #944510; color: #944510; font-family: Papyrus; font-size: 14px; text-align: right; margin: 0; padding: 5px 20px 5px 20px;'>"
                + player.getHome().getLocation().getName() + "</td>"
                + "<td style='border-color: #944510; color: #944510; font-family: Papyrus; font-size: 12px; text-align: left; margin: 0; padding: 5px 20px 5px 20px;'>"
                + nf.format((new GameCalendar().getImperiumCurrentYear()))
                + "<span style='font-size: 9px;'>AG</span></td></tr>"
                + "<tr><td colspan ='2' style='font-family: Papyrus; font-size: 12px;color: #944510; text-align: center;'>"
                + gameHourLabel + "</tr></table></html>";

        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(0, 0, 0));
        northPanel.setLayout(new GridLayout(1, 1));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        northPanel.add(new JLabel(htmlNameLabel, SwingConstants.CENTER));
        northPanel.add(new JLabel(htmlLocationLabel, SwingConstants.CENTER));
        return northPanel;
    }

    public JPanel createWestPanel(Player player) {
        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(0, 0, 0));
        westPanel.setLayout(new GridLayout(1, 1));
        String htmlLabel = "";
        westPanel.add(new JLabel(htmlLabel, SwingConstants.CENTER));
        return westPanel;
    }
}