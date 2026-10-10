import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges){
        List<Integer> ans = new ArrayList<>();

        if(n == 1){
            ans.add(0);
            return ans;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 1){
                q.offer(i);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2){
            int size = q.size();
            remainingNodes -= size;

            for(int i=0; i<size; i++){
                int node = q.poll();

                for(int adjNode : adj.get(node)){
                    indegree[adjNode]--;
                    if(indegree[adjNode] == 1){
                        q.offer(adjNode);
                    }
                }
            }
        }

        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};

        List<Integer> res = findMinHeightTrees(n, edges);
        System.out.println(res);
    }
}
