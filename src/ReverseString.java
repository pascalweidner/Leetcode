public class ReverseString {
    public void reverseString(char[] s) {
        for(int i = 0; i < (double)(s.length - 1) / 2; i++) {
            // ['a', 'b', 'c']
            s[i] ^= s[s.length - 1 - i];
            s[s.length - 1 - i] ^= s[i];
            s[i] ^= s[s.length - 1 - i];
        }
    }
}
