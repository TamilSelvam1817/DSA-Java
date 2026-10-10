import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindIfPathExistsInGraph {
    public static boolean validPath(int n, int[][] edges, int source, int destination){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[]edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        boolean[] vis = new boolean[n];
        vis[source] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            if(node == destination) return true;

            for(int adjNode : adj.get(node)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0;
        int destination = 5;

        System.out.println(validPath(n, edges, source, destination));
    }
}