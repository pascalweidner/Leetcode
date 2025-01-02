import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumIceCreamBarsTest {
    MaximumIceCreamBars bars;

    @BeforeEach
    void setUp() {
        bars = new MaximumIceCreamBars();
    }

    @Test
    void maxIceCreamNormal() {
        int[] costs = {1, 3, 2, 4, 1};
        assertEquals(4, bars.maxIceCream(costs, 7));
    }

    @Test
    void maxIceCreamNoIceCreams() {
        int[] costs = {10, 6, 8, 7, 7, 8};
        assertEquals(0, bars.maxIceCream(costs, 5));
    }

    @Test
    void maxIceCreamNoCoins() {
        int[] costs = {10, 6, 8, 7, 7, 8};
        assertEquals(0, bars.maxIceCream(costs, 0));
    }

    @Test
    void maxIceCreamAllIceCreams() {
        int[] costs = {1,6,3,1,2,5};
        assertEquals(6, bars.maxIceCream(costs, 20));
    }

    @Test
    void maxIceCreamManySorts() {
        int[] costs = {1,6,3,1,2,5,6,7,8,9,10,8,2,21,8,9,9,5,8,21,13,11,8,20,80};
        assertEquals(7, bars.maxIceCream(costs, 20));
    }

    @Test
    void maxIceCreamNoSorts() {
        int[] costs = {};
        assertEquals(0, bars.maxIceCream(costs, 20));
    }

    @Test
    void maxIceCreamHighCosts() {
        int[] costs = {100000, 1210480, 235975, 2035872058};
        assertEquals(3, bars.maxIceCream(costs, 2035872059));
    }

    @Test
    void maxIceCreamOneOrFour() {
        int[] costs = {1,1,1,1,4};
        assertEquals(4, bars.maxIceCream(costs, 4));
    }
}