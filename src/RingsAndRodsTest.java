import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingsAndRodsTest {
    RingsAndRods r;

    @BeforeEach
    void setUp() {
        r = new RingsAndRods();
    }

    @Test
    void countPointsNormalDistribution() {
        String rings = "B0B6G0R6R0R6G9";
        assertEquals(1, r.countPoints(rings));
    }

    @Test
    void countPointsMultipleOnOneRod() {
        String rings = "B0R0G0R9R0B0G0";
        assertEquals(1, r.countPoints(rings));
    }

    @Test
    void countPointsAllOnOneRod() {
        String rings = "B5R5G5R5R5B5G5";
        assertEquals(1, r.countPoints(rings));
    }

    @Test
    void countPointsOneRing() {
        String rings = "B5";
        assertEquals(0, r.countPoints(rings));
    }

    @Test
    void countPointsAllRods() {
        String rings = "B0R0G0B1R1G1B2R2G2B3R3G3B4R4G4B5R5G5B6R6G6B7R7G7B8R8G8B9R9G9";
        assertEquals(10, r.countPoints(rings));
    }

    @Test
    void countPointsNearlyAllRods() {
        String rings = "R0G0B1R1G1B2R2G2B3R3G3B4R4G4B5R5G5B6R6G6B7R7G7B8R8G8B9R9G9";
        assertEquals(9, r.countPoints(rings));
    }

    @Test
    void countPointsEmptyString() {
        String rings = "";
        assertEquals(-1, r.countPoints(rings));
    }

    @Test
    void countPointsNull() {
        String rings = null;
        assertEquals(-1, r.countPoints(rings));
    }

    @Test
    void countPointsOneOnEveryRod() {
        String rings = "R0G1B2G3G4R5B6B7G8R9";
        assertEquals(0, r.countPoints(rings));
    }
}