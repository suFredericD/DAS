package fr.das.java;

import java.nio.file.*;
import java.time.*;

public class Player extends Character {

        protected LocalDateTime birthDate;
        protected House home;

        // ===================================================================
        // CONSTRUCTEUR
        // ==================================================================================
        public Player(String name, String lastName, Faction faction, int level, int health, int maxHealth, int thirst,
                        int maxThirst,
                        int purse, int strength, int endurance, int agility, int intelligence, int charisma, int luck,
                        int stamina, int maxStamina) {
                super(name, lastName, faction, level, health, maxHealth, thirst, maxThirst, purse, strength, endurance,
                                agility,
                                intelligence, charisma, luck, stamina, maxStamina);

                // Génération de la date de naissance du joueur
                this.birthDate = LocalDateTime.now();
        }

        // =====================================================================================
        // =================================================================== FUNCTIONS
        // =====================================================================================
        public void saveGame() {
                String playerData = this.name + "," + this.lastName + "," + this.faction.getName() + "," + this.level
                                + "," + this.health + "," + this.maxHealth + "," + this.thirst + "," + this.maxThirst
                                + "," + this.purse + "," + this.strength + "," + this.endurance + "," + this.agility
                                + "," + this.intelligence + "," + this.charisma + "," + this.luck + ","
                                + this.stamina
                                + "," + this.maxStamina;

                try {
                        Files.write(Paths.get("savegame.txt"), playerData.getBytes());
                        System.out.println(ConsoleColors.GREEN
                                        + "Partie sauvegardée avec succès ! (savegame.txt)"
                                        + ConsoleColors.RESET);
                } catch (Exception e) {
                        System.out.println(ConsoleColors.RED
                                        + "Erreur lors de la sauvegarde de la partie : " + e.getMessage()
                                        + ConsoleColors.RESET);
                }
        }

        // =====================================================================================
        // =================================================================== GETTERS &
        // SETTERS
        // =====================================================================================
        public House getHome() {
                return home;
        }

        public LocalDateTime getBirthDate() {
                return birthDate;
        }

        public void setHome(House home) {
                this.home = home;
        }

        public void setBirthDate(LocalDateTime birthDate) {
                this.birthDate = birthDate;
        }
}