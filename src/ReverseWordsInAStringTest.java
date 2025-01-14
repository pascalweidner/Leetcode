import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInAStringTest {
    ReverseWordsInAString r;

    @BeforeEach
    void setUp() {
        r = new ReverseWordsInAString();
    }

    @Test
    void reverseWordsSingleSpaces() {
        assertEquals("blue is sky the", r.reverseWords("the sky is blue"));
    }

    @Test
    void reverseWordsMultipleSpacesInTheFront(){
        assertEquals("  hello world  ", r.reverseWords("the sky is blue"));
    }
}