import java.util.*;

public class Dragon {
    private int energyLevel;
    public Dragon() {
        this.energyLevel = 300;
    }
    public int getEnergyLevel() {
        return energyLevel;
    }
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    public void fly() {
        System.out.println("The dragon is taking off");
        this.energyLevel -= 50;
    }
    public void eatHumans() {
        System.out.println("Humans are snacks");
        this.energyLevel += 25;
    }
    public void attackTown() {
        System.out.println("The town is under attack and on fire");
        this.energyLevel -= 100;
    }
}