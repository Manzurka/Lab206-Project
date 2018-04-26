class Vehicle {
    private int numberOfWheels;
    private String color;
    // gettercopy
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    // setter
    public void setNumberOfWheels(int number) {
        numberOfWheels = number;
    }
    // getter
    public String getColor() {
        return color;
    }
    // setter
    public void setColor(String color) {
        this.color = color;        // 1
    }
}