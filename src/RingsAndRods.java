public class RingsAndRods {
    public static final int R = 0b001;
    public static final int G = 0b010;
    public static final int B = 0b100;

    public int countPoints(String rings) {
        if(rings == null || rings.isEmpty()) return -1;

        char[] chars = rings.toCharArray();
        final int[] rods = new int[10];

        int count = 0;
        for(int i = 0; i < rings.length(); i += 2) {
            int rod = chars[i + 1] - '0';
            char ring = chars[i];
            if((rods[rod] = setBit(rods[rod], ring)) == 7) {
                rods[rod] |= 0b1000; // make it invalid because all the rings are already on the rod
                count++;
            }
        }
        

        return count;
    }

    private int setBit(int rod, char ring) {
        if(ring == 'R') rod |= R;
        else if(ring == 'G') rod |= G;
        else if(ring == 'B') rod |= B;
        return rod;
    }
}
