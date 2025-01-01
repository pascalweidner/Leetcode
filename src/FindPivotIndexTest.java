import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexTest {
    FindPivotIndex findPivotIndex;

    @BeforeEach
    void setUp() {
        findPivotIndex = new FindPivotIndex();
    }

    @Test
    void pivotIndexMiddle() {
        int[] nums = {1,7,3,6,5,6};
        assertEquals(3, findPivotIndex.pivotIndex(nums));
    }

    @Test
    void pivotIndexBeginning() {
        int[] nums = {2,1,-1};
        assertEquals(0, findPivotIndex.pivotIndex(nums));
    }

    @Test
    void pivotIndexBeginningComplex() {
        int[] nums = {2,1,-1, 5, -5};
        assertEquals(0, findPivotIndex.pivotIndex(nums));
    }

    @Test
    void pivotIndexEnd() {
        int[] nums = {3,-3,6};
        assertEquals(2, findPivotIndex.pivotIndex(nums));
    }

    @Test
    void pivotIndexEndComplex() {
        int[] nums = {3,-3,3,-3,6};
        assertEquals(4, findPivotIndex.pivotIndex(nums));
    }

    @Test
    void pivotIndexNoPivot() {
        int[] nums = {1,2,3};
        assertEquals(-1, findPivotIndex.pivotIndex(nums));
    }

    @Test
    void privotIndexNegative() {
        int[] nums = {-1,-1,-1,-1,-1,0};
        findPivotIndex.pivotIndex(nums);
    }
}