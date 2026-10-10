import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second =second;
    }

}
class Tuple{
    int stop;
    int node;
    int cost;
    Tuple(int stop, int node, int cost){
        this.stop =stop;
        this.node = node;
        this.cost =cost;
    }
}
public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i=0; i<m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));

        int[] dist = new int[n];
        for(int i=0; i<n; i++) dist[i] = (int)1e9;

        dist[src] = 0;

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            int stop = tuple.stop;
            int node = tuple.node;
            int cost = tuple.cost;

            if(stop > k) continue;

            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int edgeWeight = it.second;
                if(cost + edgeWeight < dist[adjNode] && stop <= k){
                    dist[adjNode] = cost + edgeWeight;
                    q.offer(new Tuple(stop+1, adjNode, cost + edgeWeight));
                }
            }
        }

        if(dist[dst] == 1e9) return -1;
        return dist[dst];
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600}};
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}
