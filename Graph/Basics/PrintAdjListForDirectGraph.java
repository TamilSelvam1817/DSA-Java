import java.util.*;

public class PrintAdjListForDirectGraph {
    public static void printAdjList(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        for(int i=0; i<V; i++){
            System.out.print(i+" -> ");
            for(int it : adj.get(i)){
                System.out.print(it);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        printAdjList(V, edges);
        
    }
}
