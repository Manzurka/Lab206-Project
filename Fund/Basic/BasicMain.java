public class BasicMain {
    public static void main(String[] args) {
        Basic basic = new Basic();
        basic.printTo255();
        basic.printOdds();
        basic.printSum();
        int[] x = {1,3,5,7,9,13};
        basic.iteratingArray(x);
        basic.findMax(x);
        basic.getAverage(x);
        basic.arrayOdds();
        basic.greaterY(x,4);
        basic.squareValues(x);
        basic.negativeNum(x);
        basic.maxminAverage(x);
        basic.shiftArray(x);
    }
}