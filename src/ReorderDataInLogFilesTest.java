import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderDataInLogFilesTest {
    ReorderDataInLogFiles r;

    @BeforeEach
    void setUp() {
        r = new ReorderDataInLogFiles();
    }

    @Test
    void reorderLogFilesNotOrderedAllDifferent() {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] res = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }

    @Test
    void reorderLogFilesNotOrderedEqualLets() {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 art can","let3 art zero"};
        String[] res = {"let1 art can","let2 art can","let3 art zero", "dig1 8 1 5 1","dig2 3 6"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }

    @Test
    void reorderLogFilesNotOrderedCompletelyEqualLets() {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let1 art can","let3 art zero"};
        String[] res = {"let1 art can","let1 art can","let3 art zero", "dig1 8 1 5 1","dig2 3 6"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }

    @Test
    void reorderLogFilesNotOrderedEqualDig() {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 8 1 5 1","let1 art can","let3 art zero"};
        String[] res = {"let1 art can","let1 art can","let3 art zero", "dig1 8 1 5 1","dig2 8 1 5 1"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }

    @Test
    void reorderLogFilesNotOrderedDig1SmallerDig2() {
        String[] logs = {"dig1 1","let1 art can","dig2 2","let1 art can","let3 art zero"};
        String[] res = {"let1 art can","let1 art can","let3 art zero", "dig1 1","dig2 2"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }

    @Test
    void reorderLogFilesNotOrderedDig1BiggerDig2() {
        String[] logs = {"dig2 1","let1 art can","dig1 2","let1 art can","let3 art zero"};
        String[] res = {"let1 art can","let1 art can","let3 art zero", "dig2 1","dig1 2"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }

    @Test
    void reorderLogFilesNotOrderedNegativeNumbers() {
        String[] logs = {"dig-1 1","let1 art can","dig2 -1","let1 art can","let3 art zero"};
        String[] res = {"let1 art can","let1 art can","let3 art zero", "dig-1 1","dig2 -1"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }

    @Test
    void reorderLogFilesNotUniformIdentifies() {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] res = {"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        assertArrayEquals(res, r.reorderLogFiles(logs));
    }
}