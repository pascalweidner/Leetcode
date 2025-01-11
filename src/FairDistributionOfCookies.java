import java.util.Arrays;

public class FairDistributionOfCookies {
    public int distributeCookies(int[] cookies, int k) {
        if(cookies == null) return -1;
        return distributeCookies(cookies, 0, new int[k], 0);
    }

    public int distributeCookies(int[] cookies, int i, int[] k, int zeroCount) {
        if(cookies.length - i < zeroCount) {
            return Integer.MAX_VALUE;
        }
        if(i == cookies.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int value : k) {
                unfairness = Math.max(unfairness, value);
            }
            return unfairness;
        }
        int max = Integer.MAX_VALUE;
        for(int j = 0; j < k.length; j++) {
            zeroCount -= k[j] == 0 ? 1 : 0;
            k[j] += cookies[i];
            int newMax = distributeCookies(cookies, i + 1, k, zeroCount);
            max = Math.min(max, newMax);
            k[j] -= cookies[i];
            zeroCount += k[j] == 0 ? 1: 0;
        }
        return max;
    }
}
