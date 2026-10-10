public class MinimumNoOfdaysToMakeMBouquets1482 {
    private static boolean isPossible(int[] arr, int day, int k ,int m){
        int cnt = 0;
        int bouquets = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= day){
                cnt++;
                if(cnt == k){
                    bouquets++;
                    cnt = 0;
                }
            }else{
                cnt = 0;
            }
        }
        
        return bouquets >= m;
    }
    /* public static int minDaysBloom(int[] arr, int k, int m) {
        if(m*k > arr.length) return -1;

        int min = 0;
        int max = 0;
        for(int a : arr){
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        
        for(int i=min; i<=max; i++){
            if(isPossible(arr, i, k, m) == true){
                return i;
            }
        }
        
        return -1;
    } */

    public static int minDaysBloom(int[] arr, int k, int m) {
        
        if(m*k > arr.length) return -1;
        int low = 0;
        int high = 0;
        int ans = -1;
        for(int a : arr){
            low = Math.min(low, a);
            high = Math.max(high, a);
        }
        
        while(low <= high){
            int mid = (low+high)/2;
            if(isPossible(arr, mid, k, m) == true){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(minDaysBloom(bloomDay, k, m));
    }
}