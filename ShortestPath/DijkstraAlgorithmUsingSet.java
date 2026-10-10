import java.util.*;

class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}
public class DijkstraAlgorithmUsingSet {
    public static int[] dijkstra(int V, int[][] edges, int src){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        TreeSet<Pair> set = new TreeSet<>((a,b)->{
            if(a.distance != b.distance){
                return Integer.compare(a.distance, b.distance);
            }
            return Integer.compare(a.node, b.node);
        });

        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = (int)1e9;
        }

        dist[src] = 0;
        set.add(new Pair(0, src));

        while(!set.isEmpty()){
            Pair it  = set.pollFirst();
            int dis = it.distance;
            int node = it.node;

            for(Pair iter : adj.get(node)){
                int edgeWeight = iter.distance;
                int adjNode = iter.node;

                if(dis + edgeWeight < dist[adjNode]){
                    if(dist[adjNode] != 1e9){
                        set.remove(new Pair(dist[adjNode], adjNode));
                    }
                    dist[adjNode] = dis + edgeWeight;
                    set.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        int V1 = 3;
        int[][] edges1 = {{0,1,1},{1,2,3},{0,2,6}};
        int src1 = 2;

        int[] ans1 = dijkstra(V1, edges1, src1);
        System.out.println(Arrays.toString(ans1));

        int V2 = 5;
        int[][] edges2 = {{0,1,4},{0,2,8},{1,4,6},{2,3,2},{3,4,10}};
        int src2 = 0;

        int[] ans2 = dijkstra(V2, edges2, src2);
        System.out.println(Arrays.toString(ans2));
    }
}
