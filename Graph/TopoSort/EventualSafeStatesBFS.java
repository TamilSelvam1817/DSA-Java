import java.util.*;

public class EventualSafeStatesBFS {
    public static List<Integer> eventualSafeNode(int[][] graph){
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int it : graph[i]){
                adj.get(i).add(it);
            }
        }

        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);

            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};

        List<Integer> ans = eventualSafeNode(graph);
        System.out.println(ans);
    }
}
