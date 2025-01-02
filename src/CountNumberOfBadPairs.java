import java.util.HashMap;

public class CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> valid = new HashMap<>();
        long count = 0;
        for(int i = 0; i < nums.length; i++) {
            int prev = valid.getOrDefault(i - nums[i], 0);
            count += prev;
            valid.put(i - nums[i], prev + 1);
        }

        return binomialCoefficient(nums.length) - count;
    }

    public long binomialCoefficient(int n) {
            if(n < 2) return 0;
            return ((long) n * (n - 1)) / 2;
    }
}
