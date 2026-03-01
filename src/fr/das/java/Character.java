package fr.das.java;

public abstract class Character {
    // ==============================================================================
    // =================================================================== ATTRIBUTS
    // ==============================================================================

    protected String name;
    protected String lastName;
    protected Faction faction;
    protected int level;

    protected int health;
    protected int maxHealth;
    protected int thirst;
    protected int maxThirst;
    protected int stamina;
    protected int maxStamina;

    protected int purse;

    protected int strength;
    protected int endurance;
    protected int agility;
    protected int intelligence;
    protected int charisma;
    protected int luck;

    protected int attack;
    protected int defense;

    // ==================================================================================
    // ===================================================== CONSTRUCTEUR
    // ==================================================================================

    public Character(String name, String lastName, Faction faction, int level, int health, int maxHealth, int thirst,
            int maxThirst,
            int purse, int strength, int endurance, int agility, int intelligence, int charisma, int luck,
            int stamina, int maxStamina) {
        this.name = name;
        this.lastName = lastName;
        this.faction = faction;
        this.level = level;

        this.health = health;
        this.maxHealth = maxHealth;
        this.thirst = thirst;
        this.maxThirst = maxThirst;

        this.purse = purse;
        this.stamina = stamina;
        this.maxStamina = maxStamina;

        this.strength = strength;
        this.endurance = endurance;
        this.agility = agility;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.luck = luck;

        this.stamina = stamina;
        this.attack = calculateAttack();
        this.defense = calculateDefense();
    }

    // =====================================================================================
    // =================================================================== FUNCTIONS
    // =====================================================================================
    public int calculateAttack() {
        // Exemple de calcul d'attaque basé sur les attributs
        int attack = this.strength + (this.agility / 2) + (this.luck / 3);
        return attack;
    }

    public int calculateDefense() {
        // Exemple de calcul de défense basé sur les attributs
        int defense = this.endurance + (this.agility / 2) + (this.luck / 3);
        return defense;
    }

    // =====================================================================================
    // ====================================================== GETTERS & SETTERS
    // =====================================================================================
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Faction getFaction() {
        return faction;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getThirst() {
        return thirst;
    }

    public int getMaxThirst() {
        return maxThirst;
    }

    public int getPurse() {
        return purse;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getLuck() {
        return luck;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setMaxThirst(int maxThirst) {
        this.maxThirst = maxThirst;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}