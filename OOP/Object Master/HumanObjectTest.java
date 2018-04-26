public class HumanObjectTest {
    public static void main(String[] args) {
        HumanObject muggle1 = new HumanObject();
        HumanObject muggle2 = new HumanObject();
        muggle1.attack(muggle2);
        System.out.println(muggle2.getHealth());
    }
}