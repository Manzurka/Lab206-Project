public class WizardObject extends HumanObject {
    public WizardObject() {
        this.health = 50;
        this.intelligence = 8;
    }
    public void heal(HumanObject muggle) {
        muggle.setHealth(this.intelligence);
    }
    public void fireball(HumanObject muggle) {
        muggle.setHealth(-(this.intelligence * 3));
    }
}