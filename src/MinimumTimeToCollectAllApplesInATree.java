import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumTimeToCollectAllApplesInATree {
    private Set<Integer> seen = new HashSet<>();

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Set<Integer>> adjacent = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacent.add(new HashSet<>());
        }

        for(int[] e : edges) {
            adjacent.get(e[0]).add(e[1]);
            adjacent.get(e[1]).add(e[0]);
        }

        int result = minTime(0, adjacent, hasApple);
        return result == 0 ? 0 : result - 2;
    }

    public int minTime(int n, List<Set<Integer>> adjacent, List<Boolean> hasApple) {
        if(seen.contains(n)) return 0;
        seen.add(n);

        int total = hasApple.get(n) ? 2 : 0;

        for(Integer child: adjacent.get(n)) {
            total += minTime(child, adjacent, hasApple);
        }

        return total == 0 || hasApple.get(n) ? total : total + 2;
    }
}
