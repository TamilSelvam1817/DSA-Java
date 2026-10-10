import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitDistance {

    public static int[] shortestPath(int V, int[][] edges, int src){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = (int) 1e9;
        }

        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int adjNode : adj.get(node)){
                if(dist[node] + 1 < dist[adjNode]){
                    dist[adjNode] = dist[node] + 1;
                    q.offer(adjNode);
                }
            }
        }

        for(int i=0; i<V; i++){
            if(dist[i] == 1e9)
                dist[i] = -1;
        }

        return dist;
    }
    public static void main(String[] args) {
        int V = 9;
        int[][] edges = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{6,7},{7,8},{6,8},{2,6}};
        int src = 0;

        int[] res = shortestPath(V, edges, src);
        System.out.println(Arrays.toString(res));
    }
}