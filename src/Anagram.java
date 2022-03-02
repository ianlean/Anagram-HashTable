import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Anagram {

    private final ArrayList<String> myWords = new ArrayList<>();
    private final String myAnagram;

    public Anagram(String theWord) {
        myWords.add(theWord);
        myAnagram = findAnagram(theWord);
    }

    public String getKey() {
        return myAnagram;
    }

    public ArrayList<String> getValues() {
        return myWords;
    }

    public void addToList(String s) {
        myWords.add(s);
    }

    public static String findAnagram(String theWord) {
        StringBuilder result = new StringBuilder();
        char[] arr = theWord.toCharArray();
        Arrays.sort(arr);
        for (char c : arr) {
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        String s = "";
        for (String r: myWords) {
            s += " " + r;
        }
        return s;
    }
}
