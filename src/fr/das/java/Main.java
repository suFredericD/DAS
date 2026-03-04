package fr.das.java;

import java.util.List;

public class Main {
        public static void main(String[] args) {
                // Génération des éléments
                List<Faction> factions = generateFactions();
                List<Location> locations = generateLocations(factions);

                // Génération du joueur
                Player player = new Player("Ilric", "Haune", factions.get(3), 1, 100, 100, 100, 100, 100, 20, 20, 20,
                                20, 20,
                                10,
                                100, 100);

                House playerHouse = new House("Maison du joueur",
                                "Ta maison personnelle, un refuge sûr et un symbole de ton statut sur Arrakis.",
                                locations.get(1), player, 1000);

                // Attribution des éléments du jeu
                player.setHome(playerHouse);

                // Génération de la partie

                // Page d'accueil de la console
                clearConsole(); // Réinitialisation de la console
                System.out.println(ConsoleColors.YELLOW + "====================================================");
                System.out.println("DUNE : ARRAKIS SMUGGLER");
                System.out.println("====================================================" + ConsoleColors.RESET);
                System.out.println("Elements creation status\n- - - - - - - - - - - - - -\n"
                                + ConsoleColors.YELLOW + "Factions generated    : "
                                + ConsoleColors.RESET + factions.size() + "\n"
                                + ConsoleColors.YELLOW + "Locations generated   : "
                                + ConsoleColors.RESET + locations.size() + "\n"
                                + "- - - - - - - - - - - - - -" + ConsoleColors.RESET);
                System.out.println("");

                new ScreenWelcome(player, playerHouse);

                // Retours en console

                // Fin d'affichage console : message de fermeture systématique
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        System.out.println(
                                        ConsoleColors.YELLOW + "_____________________________________ fin d'éxécution\n"
                                                        + ConsoleColors.RESET);
                }));
        }
        // ==============================================================================
        // =================================================================== FONCTIONS
        // ==============================================================================

        // ===================================================================
        // Génération des éléments
        public static List<Faction> generateFactions() {
                Faction atreides = new Faction("Atréides",
                                "La maison noble des Atreides, connue pour son honneur, sa loyauté et sa sagesse.",
                                "Maison majeure");
                Faction harkonnen = new Faction("Harkonnen",
                                "La maison rivale des Atréides, caractérisée par sa cruauté, sa soif de pouvoir et son règne de terreur.",
                                "Maison majeure");
                Faction fremen = new Faction("Fremen",
                                "Les habitants indigènes d'Arrakis, des guerriers redoutables vivant dans les sietchs et maîtrisant les secrets du désert.",
                                "Peuple indigène");
                Faction smugglers = new Faction("Contrebandiers",
                                "Les contrebandiers opérant sur Arrakis, spécialisés dans le commerce illégal d'épice et d'autres biens.",
                                "Faction planétaire");
                List<Faction> factions = List.of(atreides, harkonnen, fremen, smugglers); // crée une liste immuable
                return factions;
        }

        public static List<Location> generateLocations(List<Faction> factions) {
                Location tabr = new Location("Sietch Tabr",
                                "Un sietch situé dans les montagnes, connu pour son chef Stilgar et son marché noir florissant.",
                                factions.get(2), 1237, "Sietch");
                Location arrakeen = new Location("Arrakeen",
                                "La capitale atreide d'Arrakis, un centre de pouvoir et de commerce, avec des fortifications imposantes et une population cosmopolite.",
                                factions.get(0), 1789, "Ville");
                Location neocarthag = new Location("Neo-Carthag",
                                "La ville harkonnen construite comme base de repli stratégique, connue pour ses industries et son énergie.",
                                factions.get(1), 1842, "Ville");
                List<Location> locations = List.of(tabr, arrakeen, neocarthag);
                return locations;
        }

        // ======================================= OUTILS
        // Astuce pour réinitialiser l'affichage de la console
        public static void clearConsole() {
                try {
                        if (System.getProperty("os.name").contains("Windows")) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } else {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                        }
                } catch (Exception e) {
                        System.out.println("Error clearing console: " + e.getMessage());
                }
        }
}