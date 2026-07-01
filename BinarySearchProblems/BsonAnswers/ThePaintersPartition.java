public class ThePaintersPartition {
    private static boolean isPossible(int[] arr, int k, int mid){
        int painters = 1;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > mid) return false;
            if(sum + arr[i] > mid){
                painters++;
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }
        if(painters > k) return false;
        return true;
    }
    public static int minTime(int[] arr, int k) {
        if(k > arr.length) return -1;
        int low = 0;
        int high = 0;
        for(int x : arr){
            low = Math.max(low, x);
            high += x;
        }
        int ans = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            if(isPossible(arr, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};
        int k = 1;
        System.out.println(minTime(arr, k));
    }
}
