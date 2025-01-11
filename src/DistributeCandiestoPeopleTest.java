import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistributeCandiestoPeopleTest {
    DistributeCandiestoPeople p;

    @BeforeEach
    void setUp() {
        p = new DistributeCandiestoPeople();
    }

    @Test
    void distribute7CandiesTo4People() {
        assertArrayEquals(new int[]{1,2,3,1}, p.distributeCandies(7, 4));
    }

    @Test
    void distribute10CandiesTo4People() {
        assertArrayEquals(new int[]{1,2,3,4}, p.distributeCandies(10, 4));
    }

    @Test
    void distribute10CandiesTo3People() {
        assertArrayEquals(new int[]{5,2,3}, p.distributeCandies(10, 3));
    }

    @Test
    void distribute36CandiesTo4People() {
        assertArrayEquals(new int[]{6,8,10,12}, p.distributeCandies(36, 4));
    }

    @Test
    void distribute38CandiesTo4People() {
        assertArrayEquals(new int[]{8,8,10,12}, p.distributeCandies(38, 4));
    }

    @Test
    void distribute78CandiesTo4People() {
        assertArrayEquals(new int[]{8,8,10,12}, p.distributeCandies(78, 4));
    }
}