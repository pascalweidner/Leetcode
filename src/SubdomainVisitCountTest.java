import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SubdomainVisitCountTest {
    SubdomainVisitCount count;

    @BeforeEach
    void setUp() {
        count = new SubdomainVisitCount();
    }

    @Test
    void subdomainVisitsOneDomain() {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        String[] result = {"9001 com", "9001 leetcode.com", "9001 discuss.leetcode.com"};
        assertArrayEquals(result, count.subdomainVisits(cpdomains).toArray());
    }

    @Test
    void subdomainVisitsMultipleDomains() {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        String[] result = {"901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"};
        Set<String> expected = new HashSet<>(List.of(result));
        Set<String> actual = new HashSet<>(count.subdomainVisits(cpdomains));
        assertEquals(expected, actual);
    }

    @Test
    void subdomainVisitsNoDomains() {
        String[] cpdomains = {};
        String[] result = {};
        Set<String> expected = new HashSet<>(List.of(result));
        Set<String> actual = new HashSet<>(count.subdomainVisits(cpdomains));
        assertEquals(expected, actual);
    }

    @Test
    void subdomainVisitsNoSameDomains() {
        String[] cpdomains = {"9001 discuss.leetcode.com", "5000 amazon.de"};
        String[] result = {"9001 discuss.leetcode.com", "5000 amazon.de", "5000 de", "9001 leetcode.com", "9001 com"};
        Set<String> expected = new HashSet<>(List.of(result));
        Set<String> actual = new HashSet<>(count.subdomainVisits(cpdomains));
        assertEquals(expected, actual);
    }

    @Test
    void subdomainVisitsSameDomains() {
        String[] cpdomains = {"9001 discuss.leetcode.com", "5000 discuss.leetcode.com"};
        String[] result = {"14001 discuss.leetcode.com", "14001 leetcode.com", "14001 com"};
        Set<String> expected = new HashSet<>(List.of(result));
        Set<String> actual = new HashSet<>(count.subdomainVisits(cpdomains));
        assertEquals(expected, actual);
    }
}