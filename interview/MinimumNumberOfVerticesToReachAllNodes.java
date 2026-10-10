import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges){
        int[] indegree = new int[n];

        for(List<Integer> edge : edges){
            int it = edge.get(1);
            indegree[it]++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0)
                ans.add(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(2,1));
        edges.add(Arrays.asList(3,1));
        edges.add(Arrays.asList(1,4));
        edges.add(Arrays.asList(2,4));

        List<Integer> res = findSmallestSetOfVertices(n, edges);
        System.out.println(res);
    }
}
