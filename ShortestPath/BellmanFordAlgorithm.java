import java.util.Arrays;

public class BellmanFordAlgorithm {
    public static int[] bellmanFord(int V, int[][] edges, int src){
        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = (int)1e8;
        }

        dist[src] = 0;
        for(int i=0; i<V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        int V1 = 5;
        int[][] edges1 = {{1,3,2},{4,3,-1},{2,4,1},{1,2,1},{0,1,5}};
        int src1 = 0;

        int[] ans1 = bellmanFord(V1, edges1, src1);
        System.out.println(Arrays.toString(ans1));

        int V2 = 4;
        int[][] edges2 = {{0,1,4},{1,2,-6},{2,3,5},{3,1,-2}};
        int src2 = 0;

        int[] ans2 = bellmanFord(V2, edges2, src2);
        System.out.println(Arrays.toString(ans2));

    }
}
