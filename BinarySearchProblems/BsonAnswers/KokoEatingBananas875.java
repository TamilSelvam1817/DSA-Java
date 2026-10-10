public class KokoEatingBananas875 {
    private static long calculateHrs(int[] arr, int mid){
        long hrs = 0;
        for(int a : arr){
            hrs += (a+mid-1)/mid;
        }
        
        return hrs;
    }
    /* public static int kokoEat(int[] arr, int k) {
        int max = 0;
        
        for(int a : arr){
            max = Math.max(max, a);
        }
        
        for(int i=1; i<=max; i++){
            long requiredTime = calculateHrs(arr, i);
            
            if(requiredTime <= k){
                return i;
            }
        }
        
        return -1;
    } */

    public static int kokoEat(int[] piles, int h){
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(high, pile);
        }
        int ans = high;

        while(low <= high){
            int mid = (low+high)/2;

            long totHrs = calculateHrs(piles, mid);
            if(totHrs <= h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(kokoEat(piles, h));
    }
}
