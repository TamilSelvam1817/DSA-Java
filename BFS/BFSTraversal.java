import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    public static List<Integer> bfsOfGraph(List<List<Integer>> adj){
        int V = adj.size();
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[V];
        List<Integer> bfs = new ArrayList<>();

        q.add(0);
        vis[0] = 1;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int adjNode : adj.get(node)){
                if(vis[adjNode] == 0){
                    vis[adjNode] = 1;
                    q.offer(adjNode);
                }
            }
        }

        return bfs;
    }
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();

        // edges.add(new ArrayList<>(Arrays.asList(1,2)));
        // edges.add(new ArrayList<>(Arrays.asList(0,2)));
        // edges.add(new ArrayList<>(Arrays.asList(0,1,3,4)));
        // edges.add(new ArrayList<>(Arrays.asList(2)));
        // edges.add(new ArrayList<>(Arrays.asList(2)));

        edges.add(new ArrayList<>(Arrays.asList(2,3,1)));
        edges.add(new ArrayList<>(Arrays.asList(0)));
        edges.add(new ArrayList<>(Arrays.asList(0,4)));
        edges.add(new ArrayList<>(Arrays.asList(0)));
        edges.add(new ArrayList<>(Arrays.asList(2)));

        List<Integer> ans = bfsOfGraph(edges);
        System.out.println(ans);
    }
}