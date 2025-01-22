import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    ValidParentheses p;

    @BeforeEach
    void setUp() {
        p = new ValidParentheses();
    }

    @Test
    void isValidTwoBraces() {
        assertTrue(p.isValid("()"));
    }

    @Test
    void isValidBracesOfEachKindBehindEachOther() {
        assertTrue(p.isValid("(){}[]"));
    }

    @Test
    void isValidNestedEqualBraces() {
        assertTrue(p.isValid("(((())))"));
    }

    @Test
    void isValidNestedDifferentBraces() {
        assertTrue(p.isValid("([{[()]}])"));
    }

    @Test
    void isInvalidValidNestedDifferentBraces() {
        assertFalse(p.isValid("([{[(])}])"));
    }

    @Test
    void isInvalidValidOnlyOpenBraces() {
        assertFalse(p.isValid("([{[("));
    }

    @Test
    void isValidEmptyString() {
        assertTrue(p.isValid(""));
    }

    @Test
    void isInvalidDifferentBracesCloseEachOther() {
        assertFalse(p.isValid("(]"));
        assertFalse(p.isValid("(}"));
        assertFalse(p.isValid("[)"));
        assertFalse(p.isValid("{)"));
    }

    @Test
    void isInvalidOnlyClosingBrackets() {
        assertFalse(p.isValid("]"));
    }


}