import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfUniqueElementsTest {
    SumOfUniqueElements s;

    @BeforeEach
    void setUp() {
        s = new SumOfUniqueElements();
    }

    @Test
    void sumOfUniqueTwoEqualElements() {
        int[] nums = {1,2,3,2};
        assertEquals(4, s.sumOfUnique(nums));
    }

    @Test
    void sumOfUniqueAllEqual() {
        int[] nums = {1,1,1,1,1};
        assertEquals(0, s.sumOfUnique(nums));
    }

    @Test
    void sumOfUniqueNoEqualElements() {
        int[] nums = {1,2,3,4,5};
        assertEquals(15, s.sumOfUnique(nums));
    }

    @Test
    void sumOfUniqueNoElements() {
        int[] nums = {};
        assertEquals(0, s.sumOfUnique(nums));
    }

    @Test
    void sumOfUniqueNull() {
        int[] nums = null;
        assertEquals(-1, s.sumOfUnique(nums));
    }

    @Test
    void sumOfUniqueTwoElementsRespectivelyEquals() {
        int[] nums = {1,2,1,2,3,3};
        assertEquals(0, s.sumOfUnique(nums));
    }

    @Test
    void sumOfUniqueOnlyOneNotEqual() {
        int[] nums = {1,2,1,2,4};
        assertEquals(4, s.sumOfUnique(nums));
    }
}