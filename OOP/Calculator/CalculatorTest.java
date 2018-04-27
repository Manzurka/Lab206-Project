public class CalculatorTest {
    public static void main(String[] args) {
        Calculator TI84 = new Calculator();
        TI84.setOperandOne(10.5);
        TI84.setOperandTwo(5.2);
        TI84.setOperation('+');
        System.out.println(TI84.getResults());
    }
}