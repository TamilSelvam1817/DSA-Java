import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    private static boolean bfsCheck(int start, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int adjNode : graph[node]){
                if(color[adjNode] == -1){
                    color[adjNode] = 1-color[node];
                    q.offer(adjNode);
                }else if(color[adjNode] == color[node]){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean isBipartite(int[][] graph){
        int V = graph.length;
        int[] color = new int[V];
        for(int i=0; i<V; i++){
            color[i] = -1;
        }

        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(bfsCheck(i, graph, color) == false)
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
