import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).map(entry -> String.valueOf(entry.getKey()).repeat(Math.toIntExact(entry.getValue())))
                .collect(Collectors.joining());
    }
}
