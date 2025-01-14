import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
       String[] outputText = s.split("\\s+");
       return IntStream.iterate(outputText.length -1, i-> i-1).limit(outputText.length)
               .mapToObj(i -> outputText[i]).collect(Collectors.joining(" ")).trim();
    }
}
