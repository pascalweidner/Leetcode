import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FairDistributionOfCookiesTest {
    FairDistributionOfCookies f;

    @BeforeEach
    void setUp() {
        f = new FairDistributionOfCookies();
    }

    @Test
    void distributeCookiesBetween2Children() {
        int[] cookies = {8, 15, 10, 20, 8};
        assertEquals(31, f.distributeCookies(cookies, 2));
    }

    @Test
    void distributeCookiesBetween3Children() {
        int[] cookies = {6,1,3,2,2,4,1,2};
        assertEquals(7, f.distributeCookies(cookies, 3));
    }

    @Test
    void distributeNoCookies() {
        int[] cookies = {};
        assertEquals(0, f.distributeCookies(cookies, 3));
    }

    @Test
    void distributeNull() {
        assertEquals(-1, f.distributeCookies(null, 3));
    }
    @Test
    void distributeCookiesBetweenNoChildren() {
        assertEquals(-1, f.distributeCookies(null, 0));
    }

    @Test
    void distributeOneCookieBetweenManyChildren() {
        assertEquals(1, f.distributeCookies(new int[]{1}, 200));
    }

    @Test
    void distributeManyCookiesBetweenLesserChildren() {
        assertEquals(71, f.distributeCookies(new int[]{20, 32, 10, 1, 3, 5}, 1));
    }

    @Test
    void distributeBigCookieBags() {
        assertEquals(76265, f.distributeCookies(new int[]{76265,7826,16834,63341,68901,58882,50651,75609}, 8));
    }
}