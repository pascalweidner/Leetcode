import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> res = IntStream.range(0, nums.length).filter(i -> {
            int comp = target - nums[i];
            map.putIfAbsent(nums[i], i);
            return map.containsKey(comp);
        }).mapToObj(i -> new int[]{i, map.get(target - nums[i])}).filter(i -> i[0] != i[1]).toList();
        return res.get(0);
    }
}
