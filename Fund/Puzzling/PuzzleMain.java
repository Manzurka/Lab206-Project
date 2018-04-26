public class PuzzleMain {
    public static void main(String[] args) {
        PuzzleJava z = new PuzzleJava();
        System.out.println("Returning numbers higher than 10: " + z.printSum());
        System.out.println("Returning names longer than 5: " + z.shuffleArray());
        z.shuffleLetters();
        System.out.println(Arrays.toString(z.randomNumber()));
        int[] array = z.randomSort();
        System.out.println(Arrays.toString(array));
        System.out.println("The min is: " + array[0] + "The max is: " + array[array.length-1]);
        System.out.println(z.randomStr());
        z.randomArr();
    }
}