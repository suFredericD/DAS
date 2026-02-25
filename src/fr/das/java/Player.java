package fr.das.java;

import java.nio.file.*;

public class Player extends Character {
        // ===================================================================
        // CONSTRUCTEUR
        // ==================================================================================
        public Player(String name, String lastName, int level, int health, int maxHealth, int thirst, int maxThirst,
                        int purse, int strength, int endurance, int agility, int intelligence, int charisma, int luck,
                        int stamina, int maxStamina) {
                super(name, lastName, level, health, maxHealth, thirst, maxThirst, purse, strength, endurance, agility,
                                intelligence, charisma, luck, stamina, maxStamina);
        }

        // =====================================================================================
        // =================================================================== FUNCTIONS
        // =====================================================================================
        public void saveGame() {

        }

        public void displayStats() {
                System.out.println(ConsoleColors.YELLOW + "Nom : " + this.name + " " + this.lastName);
                System.out.println(ConsoleColors.YELLOW + "Niveau : " + this.level);
                System.out.println(ConsoleColors.YELLOW + "Santé : " + ConsoleColors.GREEN + this.health
                                + ConsoleColors.WHITE
                                + " / " + ConsoleColors.GREEN + this.maxHealth);
                System.out.println(ConsoleColors.YELLOW + "Soif : " + ConsoleColors.BLUE + this.thirst
                                + ConsoleColors.WHITE
                                + " / " + ConsoleColors.BLUE + this.maxThirst);
                System.out.println(ConsoleColors.YELLOW + "Stamina : " + ConsoleColors.PURPLE + this.stamina
                                + ConsoleColors.WHITE + " / " + ConsoleColors.PURPLE + this.maxStamina);
                System.out.println(ConsoleColors.YELLOW + "Argent : " + ConsoleColors.YELLOW + this.purse + " solaris");
                System.out.println(ConsoleColors.YELLOW + "---------------------------------------------------");
                System.out.println(ConsoleColors.YELLOW + "Force : " + ConsoleColors.CYAN + this.strength);
                System.out.println(ConsoleColors.YELLOW + "Endurance : " + ConsoleColors.CYAN + this.endurance);
                System.out.println(ConsoleColors.YELLOW + "Agilité : " + ConsoleColors.CYAN + this.agility);
                System.out.println(ConsoleColors.YELLOW + "Intelligence : " + ConsoleColors.CYAN + this.intelligence);
                System.out.println(ConsoleColors.YELLOW + "Charisme : " + ConsoleColors.CYAN + this.charisma);
                System.out.println(ConsoleColors.YELLOW + "Chance : " + ConsoleColors.CYAN + this.luck);
                System.out.println(ConsoleColors.YELLOW + "---------------------------------------------------");
                System.out.println(ConsoleColors.YELLOW + "Attaque : " + ConsoleColors.WHITE + this.attack);
                System.out.println(ConsoleColors.YELLOW + "Défense : " + ConsoleColors.WHITE + this.defense);
                System.out.println(
                                ConsoleColors.YELLOW + "====================================================\n"
                                                + ConsoleColors.RESET);
        }

        // =====================================================================================
        // =================================================================== GETTERS &
        // SETTERS
        // =====================================================================================

}