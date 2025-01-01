import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int right =  total;
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if(left == right) return i;
            left += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex i = new FindPivotIndex();
        int[] nums = {1,2,3};
        nums = new int[]{1,2,3};
        System.out.println(i.pivotIndex(nums));
    }
}
