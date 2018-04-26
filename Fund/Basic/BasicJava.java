import java.util.Arrays;

public class BasicJava {
    public void printTo255() {
        for (int i=0; i<256; i++) {
            System.out.println(i);
        }
    }
    public void printOdds() {
        for (int i=1; i<256; i++) {
            if (i % 2 != 0) {
            System.out.println(i);
            }
        }
    }
    public void printSum() {
        int sum = 0;
        for (int i=0; i<256; i++) {
            System.out.println("New Number: " + i + "Sum: " +sum);
            sum += i;
        }
    }
    public void iteratingArray() {
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public void findMax(int[], arr) {
        int max = 0;
        for (int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    public void getAverage() {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        double average = (double) sum/arr.length;
        System.out.println(average;)
    }
    public void arrayOdds() {
        int[] y;
        y = new int[];
        int a = 0;
        for (int i=0; i<256; i++) {
            if (i % 2 != 1) {
                y[a];
                a += 1;
            }
        }
        System.out.println(y);
    }
    public void greaterY(int[] arr, int y) {
        int x = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > y) {
                x++
            }
        }
        System.out.println(x+ " values are greater than " +y)
    }
    public void squareValues(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            arr[i] = arr[i]*arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    public void negativeNum(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public void maxminAverage() {
        int min = 0;
        int max = 0;
        int avg = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
            avg += arr[i];
        }
        avg = avg / arr.length;
        System.out.println("The max is: " +max+ ", the min is: " +min+ ", and the average is: " +avg);
    }
    public void shiftArray(int[], arr) {
        for (int i=0; i<arr.length; i++) {
            arr[i+1] = arr[i];
        }
        arr[arr.length-1] = 0;
        System.out.println(Arrays.toString(arr));
    }
}


