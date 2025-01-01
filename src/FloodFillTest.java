import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloodFillTest {
    FloodFill floodFill;

    @BeforeEach
    void setUp() {
        floodFill = new FloodFill();
    }

    @Test
    void floodFillBasic() {
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        assertArrayEquals(new int[][] {{2, 2, 2}, {2,2,0}, {2,0,1}}, floodFill.floodFill(image, 1, 1, 2));
    }

    @Test
    void floodFillSameColor() {
        int[][] image = {{0,0,0}, {0,0,0}};
        assertArrayEquals(new int[][] {{0,0,0}, {0,0,0}}, floodFill.floodFill(image, 0, 0, 0));
    }

    @Test
    void floodFillSingleColorPicture() {
        int[][] image = {{0,0,0}, {0,0,0}};
        assertArrayEquals(new int[][] {{2,2,2}, {2,2,2}}, floodFill.floodFill(image, 0, 0, 2));
    }

    @Test
    void floodFillOneField() {
        int[][] image = {{0,1,0}, {0,0,0}};
        assertArrayEquals(new int[][] {{0,2,0}, {0,0,0}}, floodFill.floodFill(image, 0, 1, 2));
    }

    @Test
    void floodFillNegativeNumber() {
        int[][] image = {{-1,1,-1}, {-1,-1,-1}};
        assertArrayEquals(new int[][] {{0,1,0}, {0,0,0}}, floodFill.floodFill(image, 0, 0, 0));
    }

    @Test
    void floodFillNullImage() {
        assertNull(floodFill.floodFill(null, 0, 0, 0));
    }

    @Test
    void floodFillEmptyImage() {
        int[][] image = {};
        assertArrayEquals(new int[][] {}, floodFill.floodFill(image, 0, 0, 0));
    }

    @Test
    void floodFillEmptyRows() {
        int[][] image = {{}, {}};
        assertArrayEquals(new int[][] {{}, {}}, floodFill.floodFill(image, 0, 0, 0));
    }

    @Test
    void floodFillDifferentRowLength() {
        int[][] image = {{1, 2}, {1}};
        assertArrayEquals(new int[][] {{-5, 2}, {-5}}, floodFill.floodFill(image, 0, 0, -5));
    }
}