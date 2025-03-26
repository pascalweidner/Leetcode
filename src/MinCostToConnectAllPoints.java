import java.util.*;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<List<int[]>> adj = new ArrayList<>(); // stores end point node and its cost to connect
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < V; i++) {
            for(int j = i+1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[]{j, cost});
                adj.get(j).add(new int[]{i, cost});
            }
        }

        return primAlgo(V, adj);
    }

    public int primAlgo(int V, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[] inMST = new boolean[V];

        int sum = 0;

        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int wt = min[0];
            int node = min[1];

            if(inMST[node]) continue;

            sum += wt;
            inMST[node] = true;

            for(int[] temp : adj.get(node)) {
                int nei = temp[0]; // neighbor node
                int neiWT = temp[1]; // neighbor node's edge weight
                if(!inMST[nei]) {
                    pq.add(new int[]{neiWT, nei});
                }
            }
        }

        return sum;
    }
}
