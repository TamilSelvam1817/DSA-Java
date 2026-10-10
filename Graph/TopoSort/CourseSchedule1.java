import java.util.*;

public class CourseSchedule1 {
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        int V = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        if(topo.size() == V) return true;

        return false;
    }
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{0,1},{1,2},{2,0}};

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
