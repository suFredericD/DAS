package fr.das.java;

public abstract class Building {
    protected String name;
    protected String description;
    protected Location location;

    public Building(String name, String description, Location location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    // Getters et setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Location getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}