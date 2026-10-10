import java.util.*;

class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance =distance;
        this.node = node;
    }
}
public class NumberOfWaysToArriveAtDestination {
    public static int countPaths(int n, int[][] roads){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            adj.get(road[0]).add(new Pair(road[2], road[1]));
            adj.get(road[1]).add(new Pair(road[2], road[0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
        int[] dist = new int[n];
        int[] ways = new int[n];

        for(int i=0; i<n; i++){
            dist[i] = (int)1e9;
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));
        int mod = (int)1e9 + 7;

        while(!pq.isEmpty()){
            Pair it = pq.poll();
            int dis = it.distance;
            int node = it.node;

            if(dis > dist[node]) continue;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.node;
                int edgeWeight = iter.distance;

                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                }else if(dis + edgeWeight == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n-1]%mod;
    }
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(countPaths(n, roads));
    }
}
