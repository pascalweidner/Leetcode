import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindIntegerAddedToArray1 {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}
