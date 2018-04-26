public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator ();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str);
        char letter = 'o';
        Integer a = manipulator.getIndex("Coding", letter);
        System.out.println(a);
        String word = "Hello";
        String subString = "llo";
        Integer b = manipulator.getIndex(word, subString);
        System.out.println(b);
        String words = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(words);
    }
}