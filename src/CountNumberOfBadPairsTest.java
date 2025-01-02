import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CountNumberOfBadPairsTest {
    CountNumberOfBadPairs b;

    @BeforeEach
    void setUp() {
        b = new CountNumberOfBadPairs();
    }

    @Test
    void countBadPairsMany() {
        int[] nums = {4,1,3,3};
        assertEquals(5, b.countBadPairs(nums));
    }

    @Test
    void countBadPairsNoPairs() {
        int[] nums = {1,2,3,4,5};
        assertEquals(0, b.countBadPairs(nums));
    }

    @Test
    void countBadPairsNoNums() {
        int[] nums = {};
        assertEquals(0, b.countBadPairs(nums));
    }

    @Test
    void countBadPairsHalfWithHalf() {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,1,2,3,4,5,6};
        assertEquals(84, b.countBadPairs(nums));
    }

    @Test
    void countBadPairsNoPairsFromZero() {
        int[] nums = {0,1,2,3,4,5,6,7};
        assertEquals(0, b.countBadPairs(nums));
    }

    @Test
    void countBadPairsDecreasingNums() {
        int[] nums = {7,6,5,4,3,2,1};
        assertEquals(21, b.countBadPairs(nums));
    }

    @Test
    void countBadPairsNegativeNumbers() {
        int[] nums = {-7,-6,-5,-4,-3,-2,-1};
        assertEquals(0, b.countBadPairs(nums));
    }


}