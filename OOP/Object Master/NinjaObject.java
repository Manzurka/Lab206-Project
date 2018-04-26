public class NinjaObject extends HumanObject {
    public NinjaObject() {
        this.stealth = 10;
    }
    public void steal(HumanObject muggle) {
        muggle.setHealth(-(this.stealth));
        this.health += this.stealth;
    }
    public void runAway() {
        this.health -= 10;
    }
}
