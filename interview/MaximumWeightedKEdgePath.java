import java.util.ArrayList;
import java.util.List;

class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class MaximumWeightedKEdgePath {
    static int maxSum;
    public static int maxWeight(int n, int[][] edges, int k, int t){
        if(k == 0) return 0 < t ? 0 : -1;
        if(edges.length == 0) return -1;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        maxSum = -1;
        for(int i=0; i<n; i++){
            dfs(i, 0, 0, k, t, adj);
        }

        return maxSum;
    }
    private static void dfs(int node, int edgesUsed, int sum, int k, int t, List<List<Pair>> adj){
        if(edgesUsed == k){
            if(sum < t){
                maxSum = Math.max(maxSum, sum);
            }
            return;
        }

        for(Pair it : adj.get(node)){
            int adjNode = it.node;
            int ew = it.weight;
            int newSum = sum + ew;
            if(newSum < t){
                dfs(adjNode, edgesUsed + 1, newSum, k, t, adj);
            }
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,6},{1,2,8}};
        int k = 1;
        int t = 6;

        System.out.println(maxWeight(n, edges, k, t));
    }
}
