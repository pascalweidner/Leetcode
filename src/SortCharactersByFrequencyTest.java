import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SortCharactersByFrequencyTest {
    SortCharactersByFrequency f;

    @BeforeEach
    void setUp() {
        f = new SortCharactersByFrequency();
    }

    @Test
    void frequencySortTree() {
        Set<String> validOptions = new HashSet<>();
        validOptions.add("eert");
        validOptions.add("eetr");

        String result = f.frequencySort("tree");
        assertTrue(validOptions.contains(result), () -> "Result" + result + " is not in the valid options " + validOptions);
    }

    @Test
    void frequencySortCCCAAA() {
        Set<String> validOptions = new HashSet<>();
        validOptions.add("cccaaa");
        validOptions.add("aaaccc");

        String result = f.frequencySort("cccaaa");
        assertTrue(validOptions.contains(result), () -> "Result" + result + " is not in the valid options " + validOptions);
    }

    @Test
    void frequencySortAllTheSameChar() {
        Set<String> validOptions = new HashSet<>();
        validOptions.add("bbbbbb");

        String result = f.frequencySort("bbbbbb");
        assertTrue(validOptions.contains(result), () -> "Result" + result + " is not in the valid options " + validOptions);
    }

    @Test
    void frequencySortUpperAndLowerCaseLetters() {
        Set<String> validOptions = new HashSet<>();
        validOptions.add("bbaA");
        validOptions.add("bbAa");

        String result = f.frequencySort("Aabb");
        assertTrue(validOptions.contains(result), () -> "Result" + result + " is not in the valid options " + validOptions);
    }

    @Test
    void frequencySortEmptyString() {
        Set<String> validOptions = new HashSet<>();
        validOptions.add("");

        String result = f.frequencySort("");
        assertTrue(validOptions.contains(result), () -> "Result" + result + " is not in the valid options " + validOptions);
    }

    @Test
    void frequencySortAllIncreasing() {
        Set<String> validOptions = new HashSet<>();
        validOptions.add("ffffffeeeeeddddcccbba");

        String result = f.frequencySort("abbcccddddeeeeeffffff");
        assertTrue(validOptions.contains(result), () -> "Result" + result + " is not in the valid options " + validOptions);
    }


}