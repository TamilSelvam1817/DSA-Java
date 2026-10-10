import java.util.*;

public class NoOfConnectedComponents2 {
    private static void dfs(int node, List<List<Integer>> adjLs, int[] vis){
        vis[node] = 1;

        for(int adjNode : adjLs.get(node)){
            if(vis[adjNode] == 0)
                dfs(adjNode, adjLs, vis);
        }
    }
    public static int countComponents(int V,List<List<Integer>> edges){
        List<List<Integer>> adjLs = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjLs.add(new ArrayList<>());
        }

        for(int i=0; i<edges.size(); i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            adjLs.get(u).add(v);
            adjLs.get(v).add(u);
        }

        int[] vis = new int[V];
        int cnt = 0;

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, adjLs, vis);
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        // int V = 7;
        // List<List<Integer>> edges = new ArrayList<>();

        // edges.add(new ArrayList<>(Arrays.asList(0,1)));
        // edges.add(new ArrayList<>(Arrays.asList(6,0)));
        // edges.add(new ArrayList<>(Arrays.asList(2,4)));
        // edges.add(new ArrayList<>(Arrays.asList(2,3)));
        // edges.add(new ArrayList<>(Arrays.asList(3,4)));

        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(0,1)));
        edges.add(new ArrayList<>(Arrays.asList(2,1)));
        edges.add(new ArrayList<>(Arrays.asList(3,4)));

        System.out.println(countComponents(V, edges));
    }
}
