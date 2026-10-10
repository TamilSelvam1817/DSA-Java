import java.util.*;

public class TopoSortDFS {
    private static void dfs(int node, int[] vis, List<List<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;

        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                dfs(adjNode, vis, adj, st);
            }
        }

        st.push(node);
    }
    public static List<Integer> topoSort(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }

        return ans;
    }
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{1,3},{2,3},{4,1},{4,0},{5,0},{5,2}};
        List<Integer> res = topoSort(V, edges);
        System.out.println(res);
    }  
}