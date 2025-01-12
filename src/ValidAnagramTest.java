import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {
    ValidAnagram a;

    @BeforeEach
    void setUp() {
        a = new ValidAnagram();
    }

    @Test
    void isAnagramIsValid() {
        assertTrue(a.isAnagram("anagram", "nagaram"));
    }

    @Test
    void isAnagramNoAnagram() {
        assertFalse(a.isAnagram("rat", "car"));
    }
}