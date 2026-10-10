import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int node;
    int time;
    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}
public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.node - b.node);
        pq.offer(new Pair(k, 0));

        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = (int)1e9;
        }
        dist[k] = 0;

        while(!pq.isEmpty()){
            Pair it = pq.poll();
            int node = it.node;
            int time = it.time;

            if(time > dist[node]) continue;

            for(Pair iter : adj.get(node)){
                int adjNode = iter.node;
                int newTime = iter.time;
                if(time + newTime < dist[adjNode]){
                    dist[adjNode] = time + newTime;
                    pq.offer(new Pair(adjNode, time + newTime));
                }
            }
        }

        int maxTime = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == 1e9)
                return -1;

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
    public static void main(String[] args) {
        int n = 2;
        int[][] times = {{1,2,1}};
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}
