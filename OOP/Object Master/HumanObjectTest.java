public class HumanObjectTest {
    public static void main(String[] args) {
        HumanObject Bob = new HumanObject();
        HumanObject Joe = new HumanObject();
        WizardObject Ron = new WizardObject();
        NinjaObject Leonardo = new NinjaObject();
        SamuraiObject Jack = new SamuraiObject();
        Bob.attack(Joe);
        System.out.println(Joe.getHealth());
        Ron.heal(Joe);
        System.out.println(Joe.getHealth());
        Ron.fireball(Joe);
        System.out.println(Joe.getHealth());
        Leonardo.steal(Bob);
        System.out.println(Bob.getHealth());
        Leonardo.runAway();
        System.out.println(Leonardo.getStealth());
        Jack.deathBlow(Joe);
        System.out.println(Jack.getHealth());
        Jack.meditate();
        System.out.println(Jack.getHealth());
		System.out.println(Jack.howMany());
    }
}