import java.util.*;

public class DetectCycleInDirectGraphBFS {
    public static boolean isCycle(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            cnt++;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        if(cnt == V) return false;

        return true;
    }
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{5,0},{5,2},{4,0},{4,1},{2,3},{3,1}};

        System.out.println(isCycle(V, edges));
    }
}
