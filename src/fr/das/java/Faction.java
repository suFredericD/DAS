package fr.das.java;

public class Faction {
    protected String name;
    protected String description;
    protected String type;

    // ==================================================================================
    // ===================================================== CONSTRUCTEUR
    // ==================================================================================
    public Faction(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    // =====================================================================================
    // =================================================================== FUNCTIONS
    // =====================================================================================

    // =====================================================================================
    // ====================================================== GETTERS & SETTERS
    // =====================================================================================
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
    public void setType(String type) {
        this.type = type;
    }
}