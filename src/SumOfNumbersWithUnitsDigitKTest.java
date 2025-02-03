import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfNumbersWithUnitsDigitKTest {
    SumOfNumbersWithUnitsDigitK k;

    @BeforeEach
    void setUp() {
        k = new SumOfNumbersWithUnitsDigitK();
    }

    @Test
    void minimumNumbers2() {
        assertEquals(2, k.minimumNumbers(58, 9));
    }

    @Test
    void fourSetsNeeded() {
        assertEquals(10, k.minimumNumbers(90, 9));
    }
    @Test
    void tenSetsNeeded() {
        assertEquals(10, k.minimumNumbers(3000, 3));
    }

    @Test
    void bigNum() {
        assertEquals(10, k.minimumNumbers(9000, 9));
    }

    @Test
    void noValidSet() {
        assertEquals(-1, k.minimumNumbers(37, 2));
    }

    @Test
    void zeroSetsNeeded() {
        assertEquals(0, k.minimumNumbers(0, 7));
    }
}