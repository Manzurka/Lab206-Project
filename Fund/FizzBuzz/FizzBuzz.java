public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number % 3 == 0) {
            return ("Fizz");
        }
        else if (number % 5 == 0) {
            return ("Buzz");
        }
        else if (number % 3 && number % 5 == 0) {
            return ("FizzBuzz");
        }
        else {
            return Integer.toString(number);
        }
    }
}