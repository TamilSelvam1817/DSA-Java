import java.util.*;

public class DetectCycleInDirectGraphDFS {

    /* 
    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;

        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                if(dfsCheck(adjNode, adj, vis, pathVis) == true)
                    return true;
            }else if(pathVis[adjNode] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
    public static boolean isCycle(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(dfsCheck(i, adj, vis, pathVis) == true)
                    return true;
            }
        }

        return false;
    }
        */
    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis){
        vis[node] = 1;

        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                if(dfsCheck(adjNode, adj, vis) == true)
                    return true;
            }else if(vis[adjNode] == 1){
                return true;
            }
        }

        vis[node] = 2;
        return false;
    }
    public static boolean isCycle(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        int[] vis = new int[V];
        
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(dfsCheck(i, adj, vis) == true)
                    return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1},{2,0},{1,2},{2,3}};
        System.out.println(isCycle(V, edges));
    }
}