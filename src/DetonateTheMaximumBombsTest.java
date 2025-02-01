import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetonateTheMaximumBombsTest {
    DetonateTheMaximumBombs b;

    @BeforeEach
    void setUp() {
        b = new DetonateTheMaximumBombs();
    }

    @Test
    void maximumDetonationTwoBombs() {
        assertEquals(2, b.maximumDetonation(new int[][]{{2,1,3}, {6,1,4}}));
    }

    @Test
    void maximumDetonationsNoBombsOverlap() {
        assertEquals(1, b.maximumDetonation(new int[][]{{1,1,5}, {10, 10, 5}}));
    }

    @Test
    void maximumDetonationsFiveBombsOverlap() {
        assertEquals(5, b.maximumDetonation(new int[][]{{1,2,3}, {2,3,1}, {3,4,2}, {4,5,3}, {5,6,4}}));
    }
}