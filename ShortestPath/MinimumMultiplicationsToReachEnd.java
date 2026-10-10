import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int step, num;
    Pair(int step, int num){
        this.step = step;
        this.num = num;
    }
}
public class MinimumMultiplicationsToReachEnd {
    public static int minSteps(int[] arr, int start, int end){
        if(start == end) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, start));
        
        int[] dist = new int[1000];
        for(int i=0; i<1000; i++){
            dist[i] = (int)1e9;
        }
        dist[start] = 0;
        int mod = 1000;

        while(!q.isEmpty()){
            Pair it = q.poll();
            int step = it.step;
            int node = it.num;

            for(int i=0; i<arr.length; i++){
                int num = (arr[i] * node)%mod;
                if(step + 1 < dist[num]){
                    dist[num] = step + 1;

                    if(num == end) return step+1;
                    q.offer(new Pair(step+1, num));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,4};
        int start = 3;
        int end = 5;

        System.out.println(minSteps(arr, start, end));
    }
}
