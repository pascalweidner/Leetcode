import java.util.*;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> possibleJudges = new HashSet<>(Set.of(1));
        Set<Integer> notJudges = new HashSet<>();
        Map<Integer, Integer> degIn = new HashMap<>(Map.of(1, 0));


        for(var edge : trust) {
            possibleJudges.remove(edge[0]);
            notJudges.add(edge[0]);
            if(!notJudges.contains(edge[1])) {
                possibleJudges.add(edge[1]);
            }

            degIn.putIfAbsent(edge[1], 0);
            degIn.compute(edge[1], (key, value) -> value + 1);
        }

        int judge = -1;

        for (var j : possibleJudges) {
            if(degIn.get(j) == n - 1) {
                judge = j;
            }
            break;
        }

        return judge;
    }
}
