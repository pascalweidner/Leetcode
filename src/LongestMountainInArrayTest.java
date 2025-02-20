import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestMountainInArrayTest {
    LongestMountainInArray a;

    @BeforeEach
    void setUp() {
        a = new LongestMountainInArray();
    }

    @Test
    void longestMountainLength5() {
        int[] arr = {2,1,4,7,3,2,5};
        assertEquals(5, a.longestMountain(arr));
    }

    @Test
    void longestMountainLength5Plat() {
        int[] arr = {2,1,4,7,3,2,2};
        assertEquals(5, a.longestMountain(arr));
    }

    @Test
    void longestMountainNoMountain() {
        int[] arr = {2,2,2};
        assertEquals(0, a.longestMountain(arr));
    }

    @Test
    void longestMountainPlateau() {
        int[] arr = {1, 2, 2, 3, 4, 5, 4, 2};
        assertEquals(6, a.longestMountain(arr));
    }

    @Test
    void longestMountainHole() {
        int[] arr = {1, 0, -1, -2, -3, -2, -1, 0};
        assertEquals(0, a.longestMountain(arr));
    }

    @Test
    void longestMountainMountainInHole() {
        int[] arr = {1, 0, -1, -2, -3, -2, -1, 0, -1, -2};
        assertEquals(6, a.longestMountain(arr));
    }

    @Test
    void longestMountainMountainsSmaller3() {
        int[] arr = {0,1,1};
        assertEquals(0, a.longestMountain(arr));
    }

    @Test
    void longestMountainBeginning() {
        int[] arr = {2,3,1,2,3,4,5,6};
        assertEquals(3, a.longestMountain(arr));
    }
}