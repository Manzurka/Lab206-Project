import java.util.*;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> printSum() {
        ArrayList<Integer> x = new ArrayList<Integer>();
        int [] array =  {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        int sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i];
            if (array[i] > 10) {
                x.add(array[i]);
            }
        }
        System.out.println("The sum is: " + sum);
        return x;
    }

    public ArrayList<String> shuffleArray() {
        String[] array = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        Random arr = new Random();
        String y = "";
        ArrayList<String> x = new ArrayList<String>();
        for (int i=array.length; i>0; i--) {
            int arrIndex = arr.nextInt(i + 1);
            y = array[i];
            array[i] = array[arrIndex];
            array[arrIndex] = y;
        }
        for (int i=0; i<array.length; i++) {
            if (array[i].length() > 5) {
                x.add(array[i]);
            }
        }
        System.out.println("The names: " + Arrays.toString(array));
        return x;
    }

    public void shuffleLetters() {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".letterArray();
        Random arr = new Random();
        for (int i=letters.length-1; i>0; i--) {
            int arrIndex = arr.nextInt(i + 1);
            char a = letters[i];
            letters[i] = letters[arrIndex];
            letters[arrIndex] = a;
        }
        System.out.println("The first letter is: " + letters[0]);
        if ("aeiou".indexOf(letters[0]) != -1) {
            System.out.println("The first letter is a vowel");
        }
        System.out.println("The last letter is: " + letters[letters.length-1]);      
    }

    public int[] randomNumber() {
        Random arr = new Random();
        int[] array = new int[10];
        for (int i=0; i<array.length; i++) {
            int num = arr.nextInt(55) + 45;
            array[i] = num;
        }
        return array;
    }

    public int[] randomSort() {
        Random arr = new Random();
        int[] array = new int[10];
        int min;
        int max;
        for (int i=0; i<array.length; i++) {
            int num = arr.nextInt(55) +45;
            array[i] = num;
        }
        Arrays.sort(arr);
        return arr;
    }

    public String randomStr() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String string = "";
        Random arr = new Random();
        for (int i=0; i<5; i++) {
            int x = arr.nextInt(26);
            string += letters.charAt(x);
        }
        return string;
    }

    public void randomArr() {
        String[] arr = new String[10];
        for (int i=0; i<10; i++) {
            arr[i] = randomStr();
        }
        System.out.println(Arrays.toString(arr));
    }
}