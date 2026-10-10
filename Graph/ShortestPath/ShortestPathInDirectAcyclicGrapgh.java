import java.util.*;

class Pair{
    int node;
    int wght;
    Pair(int node, int wght){
        this.node = node;
        this.wght = wght;
    }
}
public class ShortestPathInDirectAcyclicGrapgh {
    private static void topoSort(int node, Stack<Integer> st, int[] vis, List<List<Pair>> adj){
        vis[node] = 1;

        for(int i=0; i<adj.get(node).size(); i++){
            int it = adj.get(node).get(i).node;
            if(vis[it] == 0){
                topoSort(it, st, vis, adj);
            }
        }

        st.push(node);
    }
    public static int[] shortestPath(int V, int[][] edges){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                topoSort(i, st, vis, adj);
            }
        }

        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = (int)1e9;
        }
        dist[0] = 0;

        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();

            for(int i=0; i<adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).wght;

                if(dist[node] + wt < dist[adjNode]){
                    dist[adjNode] = dist[node] + wt;
                }
            }
        }

        for(int i=0; i<V; i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }

        return dist;
    }
    public static void main(String[] args) {
        // int V = 4;
        // int[][] edges = {{0,1,2},{0,2,1}};
        int V = 6;
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        int[] ans = shortestPath(V, edges);
        System.out.println(Arrays.toString(ans));
    }
}
