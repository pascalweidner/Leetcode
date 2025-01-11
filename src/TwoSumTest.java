import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    TwoSum t;

    @BeforeEach
    void setUp() {
        t = new TwoSum();
    }

    @Test
    void twoSumFirstTwoElements() {
        int[] nums = {2, 7, 11, 15};
        int[] res = {0, 1};
        int[] result = t.twoSum(nums,9);
        Arrays.sort(result);
        assertArrayEquals(res, result);
    }

    @Test
    void twoSumFirstLastTwoElements() {
        int[] nums = {3,2,4};
        int[] res = {1,2};
        int[] result = t.twoSum(nums,6);
        System.out.println(Arrays.toString(result));
        Arrays.sort(result);
        assertArrayEquals(res, result);
    }

    @Test
    void twoSumSameNumbers() {
        int[] nums = {3, 3};
        int[] res = {0,1};
        int[] result = t.twoSum(nums,6);
        System.out.println(Arrays.toString(result));
        Arrays.sort(result);
        assertArrayEquals(res, result);
    }

    @Test
    void twoSumZeroAdding() {
        int[] nums = {0,4,3,0};
        int[] res = {0,3};
        int[] result = t.twoSum(nums, 0);
        System.out.println(Arrays.toString(result));
        Arrays.sort(result);
        assertArrayEquals(res, result);
    }

    @Test
    void twoSumNegativeNumbers() {
        int[] nums = {-3,4,3,90};
        int[] res = {0,2};
        int[] result = t.twoSum(nums, 0);
        System.out.println(Arrays.toString(result));
        Arrays.sort(result);
        assertArrayEquals(res, result);
    }
}