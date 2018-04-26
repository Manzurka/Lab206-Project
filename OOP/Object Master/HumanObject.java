import java.util.*;

public class HumanObject {
    protected int strength;
    protected int stealth;
    protected int intelligence;
    protected int health;

    public HumanObject() {
        strength = 3;
        stealth = 3;
        intelligence = 3;
        health = 100;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getStealth() {
        return stealth;
    }
    public void setStealth(int stealth) {
        this.stealth = stealth;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void attack(HumanObject muggle) {
        muggle.setHealth(-(this.strength));
    }
}
