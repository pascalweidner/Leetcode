import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SplitStringsBySeparatorTest {
    SplitStringsBySeparator stringsBySeparator;

    @BeforeEach
    void setUp() {
        stringsBySeparator = new SplitStringsBySeparator();
    }

    @Test
    void splitWordsBySeparatorBetween() {
        assertArrayEquals(List.of("one", "two", "three","four", "five", "six").toArray(), stringsBySeparator.splitWordsBySeparator(List.of("one.two.three","four.five","six"), '.').toArray());
    }

    @Test
    void splitWordsBySeparatorStartAndEnd() {
        var exp = List.of("easy","problem").toArray();
        var act = stringsBySeparator.splitWordsBySeparator(List.of("$easy$","$problem$"), '$').toArray();
        assertArrayEquals(exp, act);
    }

    @Test
    void splitWordsBySeparatorNoSeparatorInStrings() {
        var exp = List.of("$easy$","$problem$").toArray();
        var act = stringsBySeparator.splitWordsBySeparator(List.of("$easy$","$problem$"), '.').toArray();
        assertArrayEquals(exp, act);

        exp = List.of("one.two.three","four.five","six").toArray();
        act = stringsBySeparator.splitWordsBySeparator(List.of("one.two.three","four.five","six"), '%').toArray();
        assertArrayEquals(exp, act);
    }

    @Test
    void splitWordsBySeparatorAllSeparators() {
        var exp = List.of().toArray();
        var act = stringsBySeparator.splitWordsBySeparator(List.of("|||"), '|').toArray();
        assertArrayEquals(exp, act);
    }

    @Test
    void splitWordsBySeparatorAllSeparatorsSplit() {
        var exp = List.of().toArray();
        var act = stringsBySeparator.splitWordsBySeparator(List.of("|", "|", "|"), '|').toArray();
        assertArrayEquals(exp, act);
    }

    @Test
    void splitWordsBySeparatorDoubleSeparator() {
        var exp = List.of("Hallo", "Hallo").toArray();
        var act = stringsBySeparator.splitWordsBySeparator(List.of("Hallo&&Hallo&&"), '&').toArray();
        assertArrayEquals(exp, act);
    }

    @Test
    void splitWordsBySeparatorNoWords() {
        var exp = List.of().toArray();
        var act = stringsBySeparator.splitWordsBySeparator(List.of(), '|').toArray();
        assertArrayEquals(exp, act);
    }
}