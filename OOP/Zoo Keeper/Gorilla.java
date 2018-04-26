import java.util.*;

public class Gorilla extends Mammal {
    public Gorilla() {
        super();
    }
    public void throwSomething() {
        System.out.println("Watch out, the gorilla is throwing something!");
        super.setEnergyLevel(-5);
    }
    public void eatBananas() {
        System.out.println("The gorilla is now satisfied by eating a banana");
        super.setEnergyLevel(10);
    }
    public void climb() {
        System.out.println("The gorilla is tired by climbing a tree");
        super.setEnergyLevel(-10);
    }
}