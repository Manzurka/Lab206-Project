public class Pokemon {
    private String name;
    private int health;
    private String type;
    public static int count = 0;

    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
        count++;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public String getType() {
        return type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setType(String type) {
        this.type = type;
    }
}