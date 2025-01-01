import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindIntegerAddedToArray1Test {
    FindIntegerAddedToArray1 f;

    @BeforeEach
    void setUp() {
        f = new FindIntegerAddedToArray1();
    }

    @Test
    void addedIntegerZeroDiff() {
        int[] nums1 = {1,1,1,1};
        int[] nums2 = {1,1,1,1};
        assertEquals(0, f.addedInteger(nums1, nums2));
    }

    @Test
    void addedIntegerSorted() {
        int[] nums1 = {2, 4, 6};
        int[] nums2 = {5, 7, 9};
        assertEquals(3, f.addedInteger(nums1, nums2));
    }

    @Test
    void addedIntegerNotSorted() {
        int[] nums1 = {2, 6, 4};
        int[] nums2 = {7, 5, 9};
        assertEquals(3, f.addedInteger(nums1, nums2));
    }

    @Test
    void addedIntegerMirroredSorted() {
        int[] nums1 = {2, 4, 6};
        int[] nums2 = {9, 7, 5};
        assertEquals(3, f.addedInteger(nums1, nums2));
    }

    @Test
    void addedIntegerOneBiggerThanTwo() {
        int[] nums1 = {10};
        int[] nums2 = {5};
        assertEquals(-5, f.addedInteger(nums1, nums2));
    }

    @Test
    void addedIntegerNegativeNumbers() {
        int[] nums1 = {-1, -2, -3};
        int[] nums2 = {-5, -6, -7};
        assertEquals(-4, f.addedInteger(nums1, nums2));
    }

    @Test
    void addedIntegerNegativeNumbersNotSorted() {
        int[] nums1 = {-2, -3, -1};
        int[] nums2 = {-7, -5, -6};
        assertEquals(-4, f.addedInteger(nums1, nums2));
    }
}