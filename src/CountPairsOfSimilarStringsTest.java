import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountPairsOfSimilarStringsTest {
    CountPairsOfSimilarStrings s;

    @BeforeEach
    void setUp() {
        s = new CountPairsOfSimilarStrings();
    }

    @Test
    void similarPairsDifferentPairs() {
        assertEquals(2, s.similarPairs(List.of("aba","aabb","abcd","bac","aabc").toArray(String[]::new)));
    }

    @Test
    void similarPairsEveryPairWithEveryPair() {
        assertEquals(3, s.similarPairs(List.of("aabb","ab","ba").toArray(String[]::new)));
    }

    @Test
    void similarPairsEveryPairWithEveryPairBig() {
        assertEquals(21, s.similarPairs(List.of("aba", "aabb", "aaba", "abba", "ab", "bbaabba", "aaaab").toArray(String[]::new)));
    }

    @Test
    void similarPairsNoPairs() {
        assertEquals(0, s.similarPairs(List.of("aba", "acabb", "agaba", "ablba", "aeb", "bbaaibba", "aaakab").toArray(String[]::new)));
    }

    @Test
    void similarPairsEmptyList() {
        assertEquals(0, s.similarPairs(new String[0]));
    }

    @Test
    void similarPairsListNull() {
        assertEquals(0, s.similarPairs(null));
    }

    @Test
    void similarPairsOneCharacter() {
        assertEquals(21, s.similarPairs(List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa").toArray(String[]::new)));
    }

    @Test
    void similarPairsAllWordsEqual() {
        assertEquals(21, s.similarPairs(List.of("a", "a", "a", "a", "a", "a", "a").toArray(String[]::new)));
    }

    @Test
    void similarPairsEmptyWord() {
        assertEquals(15, s.similarPairs(List.of("", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa").toArray(String[]::new)));
    }

    @Test
    void similarPairsEmptyWords() {
        assertEquals(0, s.similarPairs(List.of("", "").toArray(String[]::new)));
    }
}