import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KSymbolinGrammarTest {
    KSymbolinGrammar k;

    @BeforeEach
    void setUp() {
        k = new KSymbolinGrammar();
    }

    @Test
    void kthGrammarN1() {
        assertEquals(0, k.kthGrammar(1, 1));
    }

    @Test
    void kthGrammarN2FirstHalf() {
        assertEquals(0, k.kthGrammar(2, 1));
    }

    @Test
    void kthGrammarN2SecondHalf() {
        assertEquals(1, k.kthGrammar(2, 2));
    }

    @Test
    void kthGrammarBigNKFirstHalf() {
        assertEquals(1, k.kthGrammar(5, 3));
    }

    @Test
    void kthGrammarBigNKBeginning() {
        assertEquals(0, k.kthGrammar(5, 1));
    }

    @Test
    void kthGrammarBigNKSecondHalf() {
        assertEquals(1, k.kthGrammar(5, 14));
    }

    @Test
    void kthGrammarBigNKEnd() {
        assertEquals(0, k.kthGrammar(5, 16));
    }

    @Test
    void kthGrammarIllegalK() {
        assertEquals(-1, k.kthGrammar(5, 0));
    }

    @Test
    void kthGrammarIllegalN() {
        assertEquals(-1, k.kthGrammar(-4, 5));
    }
}