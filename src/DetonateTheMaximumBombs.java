public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        for(var bomb : bombs) {
            int count = 1;
            for(var b : bombs) {
                if(b == bomb) continue;
                if(bomb[2] >= (int)Math.sqrt((b[0] - bomb[0]) * (b[0] - bomb[0]) + (b[1] - bomb[1]) * (b[1] - bomb[1]))) count++;
            }
            if(count > max) max = count;
        }

        return max;
    }
}
