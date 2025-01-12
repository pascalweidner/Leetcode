import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    ReverseString r;

    @BeforeEach
    void setUp() {
        r = new ReverseString();
    }

    @Test
    void reverseStringHello() {
        char[] c = "hello".toCharArray();
        r.reverseString(c);
        assertArrayEquals("olleh".toCharArray(), c);
    }

    @Test
    void reverseStringPapa() {
        char[] c = "papa".toCharArray();
        r.reverseString(c);
        System.out.println(c);
        assertArrayEquals("apap".toCharArray(), c);
    }

    @Test
    void reverseString() {
        char[] c = "".toCharArray();
        r.reverseString(c);
        assertArrayEquals("".toCharArray(), c);
    }

    @Test
    void reverseStringAnna() {
        char[] c = "anna".toCharArray();
        r.reverseString(c);
        assertArrayEquals("anna".toCharArray(), c);
    }
}