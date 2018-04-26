import java.util.*;

public class Exceptions {
    public ArrayList<Integer> a (ArrayList<Object> arr) {
        ArrayList<Integer> b = new ArrrayList<Integer();
        for (Object x : arr) {
            try {
                Integer castedValue = (Integer) x;
                System.out.println(castedValue);
                b.add(arr.indexOf(x), castedValue);    
            }
            catch (ClassCastException e) {
                Integer castedvalue = (Integer) arr.indexValue(x);
                b.add(arr.indexOf(x), castedValue);
            }
        }
        System.out.println(arr);
        return b;
    }    
}