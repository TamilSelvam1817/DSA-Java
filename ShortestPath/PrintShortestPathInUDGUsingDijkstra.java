import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}
public class PrintShortestPathInUDGUsingDijkstra {
    public static List<Integer> shortestPath(int V, int[][] edges, int src, int dest){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, v));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        int[] dist = new int[V+1];
        int[] parent = new int[V+1];

        for(int i=0; i<=V; i++){
            dist[i] = (int)1e9;
            parent[i] = i;
        }

        dist[src] = 0;
        pq.add(new Pair(0, src));

        while(!pq.isEmpty()){
            Pair it = pq.poll();
            int dis = it.distance;
            int node = it.node;

            for(Pair iter : adj.get(node)){
                int edgeWeight = iter.distance;
                int adjNode = iter.node;

                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if(dist[dest] == (int)1e9){
            path.add(-1);
            return path;
        }

        int node = dest;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);

        return path;
    }
    public static void main(String[] args) {
        // int V = 6;
        // int[][] edges = {{1,2,1},{1,3,1},{2,4,1},{3,4,1},{4,6,1},{2,5,2},{5,6,1}};
        // int src = 1;
        // int dest = 6;
        int V = 5;
        int[][] edges = {{1,2,4}, {2,3,2}, {4,5,1}};
        int src = 1;
        int dest = 5;

        List<Integer> res = shortestPath(V, edges, src, dest);
        System.out.println(res);
    }
}