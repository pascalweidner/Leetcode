public class PartitionStringIntoMinimumBeautifulSubstrings {
    public int minimumBeautifulSubstrings(String s) {
        if(beautiful(s)) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            int k = minimumBeautifulSubstrings(s2);

            if(beautiful(s1) && k != -1) {
                ans = Math.min(ans, k+1);
            }
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    public boolean beautiful(String s) {
        return s.charAt(0) == '1' && powerOf5(Integer.parseInt(s, 2));
    }

    private boolean powerOf5(int num) {
        while(num > 1 && num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        var c = new PartitionStringIntoMinimumBeautifulSubstrings();
        System.out.println(c.minimumBeautifulSubstrings("100111000110111"));
    }
}
