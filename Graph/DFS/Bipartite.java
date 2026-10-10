public class Bipartite {
    private static boolean dfs(int node, int col, int[][] graph, int[] color){
        color[node] = col;

        for(int adjNode : graph[node]){
            if(color[adjNode] == -1){
                if(dfs(adjNode, 1-col, graph, color) == false){
                    return false;
                }
            }else if(color[adjNode] == col){
                return false;
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
                if(dfs(i, 0, graph, color) == false)
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
