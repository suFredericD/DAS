package fr.das.java;

public class House extends Building {
    protected Player owner;
    protected int vault;
    protected int tankCapacity;
    protected int tankFill;

    public House(String name, String description, Location location, Player owner, int vault) {
        super(name, description, location);
        this.owner = owner;
        this.vault = vault;
        this.tankCapacity = 10000;
        this.tankFill = 5000;
    }

    public Player getOwner() {
        return owner;
    }

    public int getVault() {
        return vault;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public int getTankFill() {
        return tankFill;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setVault(int vault) {
        this.vault = vault;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void setTankFill(int tankFill) {
        this.tankFill = tankFill;
    }
}