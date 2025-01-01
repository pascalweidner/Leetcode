import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class FloodFill {
    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null) return null;
        Queue<Pair> adj = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();

        if(image.length == 0) return image;
        if(image[sr].length == 0) return image;
        adj.add(new Pair(sc, sr));

        while(!adj.isEmpty()) {
            Pair curr = adj.poll();
            int x = curr.x, y = curr.y;
            seen.add(x + "-" + y);
            int val = image[y][x];
            image[y][x] = color;

            if(x + 1 <= image[y].length - 1 && !seen.contains((x + 1) + "-" + y) && image[y][x+1] == val) {
                adj.add(new Pair(x + 1, y));
            }
            if(x - 1 >= 0  && !seen.contains((x - 1) + "-" + y) && image[y][x-1] == val) {
                adj.add(new Pair(x - 1, y) );
            }
            if(y + 1 <= image.length - 1  && !seen.contains(x + "-" + (y + 1)) && image[y + 1][x] == val) {
                adj.add(new Pair(x, y + 1));
            }
            if(y - 1 >= 0  && !seen.contains(x + "-" + (y - 1)) && image[y - 1][x] == val) {
                adj.add(new Pair(x, y - 1));
            }
        }

        return image;
    }
}
