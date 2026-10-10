import java.util.*;

public class EventualSafeStatesDFS {
    private static boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, pathVis, check) == true)
                    return true;
            }else if(pathVis[it] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        check[node] = 1;
        return false;
    }
    public static List<Integer> eventualSafeNodes(int[][] graph){
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int it : graph[i]){
                adj.get(i).add(it);
            }
        }

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(check[i] == 1)
                safeNodes.add(i);
        }

        return safeNodes;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> res = eventualSafeNodes(graph);

        System.out.println(res);
    }
}
