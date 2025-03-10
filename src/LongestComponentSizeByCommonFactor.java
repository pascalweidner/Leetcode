import java.util.*;

public class LongestComponentSizeByCommonFactor {

    public int largestComponentSize(int[] nums) {
        Map<Integer, HashSet<Integer>> factors = new HashMap<>();
        int max = Arrays.stream(nums).max().orElse(0);
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int p = 2; p * p <= max; p++) {
            if(isPrime[p]) {
                for(int i = p * p; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>(max / 2);
        for(int i = 0; i < isPrime.length; i++) if(isPrime[i]) primes.add(i);

        for(int n : nums) {
            factors.put(n, factor(n, primes));
        }

        return 0;
    }

    private HashSet<Integer> factor(int n, List<Integer> primes) {
        HashSet<Integer> factors = new HashSet<>();

        for(int p : primes) {
            if(n % p == 0) factors.add(p);
            if(p > n) break;
        }

        return factors;
    }


}
