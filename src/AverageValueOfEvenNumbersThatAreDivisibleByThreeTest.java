import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageValueOfEvenNumbersThatAreDivisibleByThreeTest {
    AverageValueOfEvenNumbersThatAreDivisibleByThree a;

    @BeforeEach
    void setUp() {
        a = new AverageValueOfEvenNumbersThatAreDivisibleByThree();
    }

    @Test
    void averageValue612() {
        assertEquals(9, a.averageValue(new int[]{1,3,6,10,12,15}));
    }

    @Test
    void averageValue0() {
        assertEquals(0, a.averageValue(new int[]{1,2,4,7,10}));
    }
}