import java.util.*;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Map<Integer, PriorityQueue<Integer>> pq = new HashMap<>();

        int count = 0;

        for(int i : nums) {
            int subseqCount = 0;
            if(pq.containsKey(i - 1)) {
                subseqCount = pq.get(i - 1).poll();
                if(pq.get(i - 1).isEmpty()) pq.remove(i - 1);
            }
            pq.putIfAbsent(i, new PriorityQueue<>());
            pq.get(i).add(subseqCount + 1);
        }

        return pq.values().stream().flatMap(elem -> elem.stream()).allMatch(elem -> elem >= 3);
    }
}
