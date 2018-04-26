public class SamuraiObject extends HumanObject {
    protected int num = 0;
    public SamuraiObject() {
        this.health = 200;
        num += 1;
    }
    public void deathBlow(HumanObject muggle) {
        muggle.health = 0;
        this.health -= this.health / 2;
    }
    public void meditate() {
        this.health += this.health /2;
    }
    public int howMany() {
        return this.num;
    }
}
