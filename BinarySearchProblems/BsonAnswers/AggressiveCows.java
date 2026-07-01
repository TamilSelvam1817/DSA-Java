import java.util.Arrays;

public class AggressiveCows {
    private static boolean canWePlace(int[] stalls, int k, int d){
        int cnt = 1;
        int lastPos = stalls[0];
        
        for(int i=1; i<stalls.length; i++){
            if(stalls[i] - lastPos >= d){
                cnt++;
                lastPos = stalls[i];
            }
            
            if(cnt >= k) return true;
        }
        
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        
        Arrays.sort(stalls);
        int maxDist = stalls[stalls.length-1] - stalls[0];
        int ans = 0;
        
        for(int d=1; d<=maxDist; d++){
            if(canWePlace(stalls, k, d)){
                ans = d;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int[] stalls = {2, 12, 11, 3, 26, 7};
        int k = 5;
        System.out.println(aggressiveCows(stalls, k));
    }
}
