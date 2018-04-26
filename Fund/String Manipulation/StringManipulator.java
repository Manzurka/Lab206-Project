public class StringManipulator {
    public String trimAndConcat(String a, String b) {
        String str = a.trim().concat(b.trim());
        return str;
    }
    public Integer getIndex(String str, char letter) {
        if (str.indexOf(letter) >= 0) {
            return str.indexOf(letter);
        }
        else {
             return null;
        }
    }
    public Integer getIndex(String str, String subString) {
        if (str.indexOf(subString) >= 0) {
            return str.indexOf(subString);
        }
        else {
             return null;
        }
    }
    public String concatSubstring(String str, int num, int num2, String str2) {
        String subString = str.substring(num, num2).concat(str2);
        return str;
    }
}