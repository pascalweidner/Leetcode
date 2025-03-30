public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int reverse = 0;
        int normal = x;
        while (normal > 0) {
            reverse *= 10;
            reverse += normal % 10;
            normal /= 10;
        }

        return x == reverse;
    }
}
