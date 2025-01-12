import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        ArrayList<Character> sList = s.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toCollection(ArrayList::new));
        return t.chars().mapToObj(c -> (char) c).sorted().takeWhile(c -> {
            System.out.println(c);
            try {return c == sList.removeFirst();}
            catch (NoSuchElementException e) {
                return false;
            }
        }).count() == s.length();
    }
}
