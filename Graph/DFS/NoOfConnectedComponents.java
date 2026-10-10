import java.util.*;

public class NoOfConnectedComponents {
    private static void dfs(int node, List<List<Integer>> adjLs, boolean[] vis){
        vis[node] = true;

        for(int neighbor : adjLs.get(node)){
            if(!vis[neighbor])
                dfs(neighbor, adjLs, vis);
        }
    }
    public static int countComponents(int V, int[][] edges){
        List<List<Integer>> adjLs = new ArrayList<>();

        for(int i=0; i<V; i++){
            adjLs.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjLs.get(edge[0]).add(edge[1]);
            adjLs.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[V];
        int cnt = 0;

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adjLs, vis);
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{4,5}};

        System.out.println(countComponents(V, edges));
    }
}
