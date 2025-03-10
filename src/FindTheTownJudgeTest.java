import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindTheTownJudgeTest {

    static List<Arguments> findJudge() {
        return List.of(
                Arguments.of(2, new int[][]{new int[]{1,2}}, 2),
                Arguments.of(3, new int[][]{new int[]{1,3}, new int[]{2,3}}, 3),
                Arguments.of(3, new int[][]{new int[]{1,3}, new int[]{2,3}, new int[]{3,1}}, -1),
                Arguments.of(1, new int[][]{}, 1)
        );
    }

    static FindTheTownJudge f;

    @BeforeAll
    public static void setup() {
        f = new FindTheTownJudge();
    }

    @ParameterizedTest
    @MethodSource
    public void findJudge(int n, int[][] graph, int judge) {
        assertEquals(judge, f.findJudge(n, graph));
    }
}