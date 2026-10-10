import java.util.*;

public class DFSTraversal {
    private static void dfsCall(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> dfs){
        vis[node] = true;
        dfs.add(node);

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                dfsCall(adjNode, adj, vis, dfs);
            }
        }
    }
    public static List<Integer> dfsOfGraph(List<List<Integer>> adj){
        int V = adj.size();
        boolean[] vis = new boolean[V];
        List<Integer> dfs = new ArrayList<>();

        dfsCall(0, adj, vis, dfs);
        return dfs;
    }
    public static void main(String[] args) {
        // List<List<Integer>> edges = new ArrayList<>();

        // edges.add(new ArrayList<>(Arrays.asList(2,3,1)));
        // edges.add(new ArrayList<>(Arrays.asList(0)));
        // edges.add(new ArrayList<>(Arrays.asList(0,4)));
        // edges.add(new ArrayList<>(Arrays.asList(0)));
        // edges.add(new ArrayList<>(Arrays.asList(2)));

        List<List<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(1,2)));
        edges.add(new ArrayList<>(Arrays.asList(0,2)));
        edges.add(new ArrayList<>(Arrays.asList(0,1,3,4)));
        edges.add(new ArrayList<>(Arrays.asList(2)));
        edges.add(new ArrayList<>(Arrays.asList(2)));

        List<Integer> ans = dfsOfGraph(edges);
        System.out.println(ans);

    }
}
