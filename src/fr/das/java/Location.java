package fr.das.java;

public class Location {

    protected String name;
    protected String description;
    protected Faction protector;
    protected int population;
    protected String type; // Ville, Sietch, Base, etc.

    // ==================================================================================
    // ===================================================== CONSTRUCTEUR
    // ==================================================================================
    public Location(String name, String description, Faction protector, int population, String type) {
        this.name = name;
        this.description = description;
        this.protector = protector;
        this.population = population;
        this.type = type;
    }

    // =====================================================================================
    // =================================================================== FUNCTIONS
    // =====================================================================================
    public void displayInfos() {
        System.out.println(ConsoleColors.YELLOW + "Lieu : " + ConsoleColors.RESET + name);
        System.out.println(ConsoleColors.YELLOW + "Type : " + ConsoleColors.RESET + type);
        System.out.println(ConsoleColors.YELLOW + "Population : " + ConsoleColors.RESET + population);
        System.out.println(ConsoleColors.YELLOW + "Description : " + ConsoleColors.RESET + description);
    }

    // =====================================================================================
    // ====================================================== GETTERS & SETTERS
    // =====================================================================================
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Faction getProtector() {
        return protector;
    }

    public int getPopulation() {
        return population;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProtector(Faction protector) {
        this.protector = protector;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setType(String type) {
        this.type = type;
    }
}