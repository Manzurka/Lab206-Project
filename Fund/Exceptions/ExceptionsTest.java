import java.util.*;

public class ExceptionsTest {
    public static void main(String[] args) {
        Exceptions c = new Exceptions();
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        System.out.println(c.a(myList));
    }
}