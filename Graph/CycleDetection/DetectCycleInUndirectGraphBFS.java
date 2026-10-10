import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class DetectCycleInUndirectGraphBFS {
    private static boolean dfs(int src, List<List<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1));

        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(int adjNode : adj.get(node)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.offer(new Pair(adjNode, node));
                }else if(parent != adjNode){
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean isCycle(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                if(dfs(i, adj, vis))
                    return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1},{1,2},{2,3}};
        System.out.println(isCycle(V, edges));
    }
}
