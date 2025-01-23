import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestMissingIntegerGreaterThanSequentialPrefixSumTest {
    SmallestMissingIntegerGreaterThanSequentialPrefixSum s;

    @BeforeEach
    void setUp() {
        s = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();
    }

    @Test
    void missingIntegerPrefixFrom1() {
        assertEquals(6, s.missingInteger(new int[]{1,2,3,2,5}));
    }

    @Test
    void missingIntegerPrefixFrom3AndSumAlreadyInTheArray() {
        assertEquals(15, s.missingInteger(new int[]{3,4,5,1,12,14,13}));
    }
}