import java.util.*;

public class NumberOfProvinces {
    private static void dfs(int node, List<List<Integer>> adjLs, int[] vis){
        vis[node] = 1;

        for(int adjNode : adjLs.get(node)){
            if(vis[adjNode] == 0)
                dfs(adjNode, adjLs, vis);
        }
    }
    public static int findCircleNum(int[][] isConnected){
        List<List<Integer>> adjLs = new ArrayList<>();
        for(int i=0; i<isConnected.length; i++){
            adjLs.add(new ArrayList<>());
        }

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected.length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int[] vis = new int[isConnected.length];
        int cnt = 0;
        for(int i=0; i<isConnected.length; i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i, adjLs, vis);
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
