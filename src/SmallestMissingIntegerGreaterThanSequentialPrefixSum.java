import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] nums) {
        if(nums.length == 0) return 0;

        int sum =nums[0];
        int i;
        for(i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i] - 1) {
                break;
            }
            sum += nums[i];
        }

        int before = sum;

        Arrays.sort(nums, i, nums.length);
        int max = 0;
        for(; i < nums.length; i++) {
            if(nums[i] > sum) break;
            if(nums[i] == sum) sum++;
            if(nums[i] > max) max = nums[i];

        }

        if(before == sum && sum + 1 <= max) sum++;

        return sum;
    }
}
