public class RLEIterator {
    private int count;
    private int index;
    private int[] encoding;
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        index = 1;
        count = encoding.length > 0 ? encoding[0] : -1;
    }

    public int next(int n) {
        while(count <= 0) {
            if(index + 1 >= encoding.length) return -1;
            count = encoding[index + 1];
            index += 2;
        }
        if(n == 0) return -1;

        while(n > 0) {
             if (count <= 0) {
                if(index + 1  >= encoding.length) return -1;
                count = encoding[index + 1];
                index += 2;
             }

             if (count > n) {
                 count -= n;
                 n = 0;
             }
             else {
                 n -= count;
                 count = 0;
             }
        }
        return encoding[index];
    }
}
