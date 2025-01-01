public class KSymbolinGrammar {
    public int kthGrammar(int n, int k) {
        if(k <= 0 || n <= 0) return -1;
        return kthGrammar(n, k, 0);
    }

    private int kthGrammar(int n, int k, int val) {
        int[] vals;
        if(val == 0) {
            vals = new int[]{0, 1};
        }
        else {
            vals = new int[]{1, 0};
        }
        if(n == 1) {
            return val;
        }

        if(k <= (Math.pow(2, n - 2))) {
            return kthGrammar(n - 1, k, vals[0]);
        }
        return kthGrammar(n - 1, (int) (k - (Math.pow(2, n - 2))), vals[1]);
    }
}
