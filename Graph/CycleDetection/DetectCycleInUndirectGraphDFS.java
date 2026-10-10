import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectGraphDFS {
    private static boolean dfs(int node, int parent, List<List<Integer>> adj, int[] vis){
        vis[node] = 1;

        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, node, adj, vis) == true)
                    return true;
            }else if(parent != adjNode)
                return true;
        }

        return false;
    }
    public static boolean isCycle(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(dfs(i, -1, adj, vis) == true)
                    return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
        System.out.println(isCycle(V, edges));
    }
}
