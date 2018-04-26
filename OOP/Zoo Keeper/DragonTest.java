public class DragonTest {
    public static void main(String[] args) {
        Dragon x = new Dragon();
        x.attackTown();
        x.attackTown();
        x.attackTown();
        x.eatHumans();
        x.eatHumans();
        x.fly();
        x.fly();
        System.out.println(x.getEnergyLevel());
    }
}