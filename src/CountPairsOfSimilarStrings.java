import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountPairsOfSimilarStrings {

    public int similarPairs(String[] words) {
        if(words == null || words.length == 0) return 0;
        Map<Set<Character>, Integer> categories = new HashMap<>();

        for(String s : words) {
            Set<Character> key = s.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
            if (key.isEmpty()) continue;
            categories.putIfAbsent(key, 0);
            categories.compute(key, (k, v) -> v + 1);
        }

        return categories.values().stream().mapToInt(this::binomialCoefficient).sum();
    }

    public int binomialCoefficient(int n) {
        if(n < 2) return 0;

        return (n * (n - 1)) / 2;
    }

    public int alternative(String[] words) {
        int n = words.length;
        int[] sets = new int[n];

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(sets[i] == sets[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
