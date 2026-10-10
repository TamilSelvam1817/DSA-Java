import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    private static void dfs(int node, List<Integer> path, List<List<Integer>> res, int[][] graph){
        int V = graph.length;
        if(node == V-1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int adjNode : graph[node]){
            path.add(adjNode);
            dfs(adjNode, path, res, graph); 
            path.remove(path.size()-1);
        }
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path, res, graph);
        return res;
    }
    public static void main(String[] args) {
        //int[][] graph = {{1,2},{3},{3},{}};
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> ans = allPathsSourceTarget(graph);
        System.out.println(ans);
    }
}