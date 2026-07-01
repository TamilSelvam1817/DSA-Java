public class FindTheSmallestDivisorGivenAThreshol1283 {
    /* public static int smallestDivisor(int[] arr, int k) {
        if(arr.length > k) return -1;

        int max = Integer.MIN_VALUE;
        
        for(int a : arr){
            max = Math.max(max, a);
        }
        
        for(int d=1; d<=max; d++){
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                sum += (int)Math.ceil((double) arr[i]/d);
            }
            
            if(sum <= k){
                return d;
            }
        }
        return -1;
    } */

    private static int sumOfDivisor(int[] nums, int mid){
        int div = 0;
        for(int n : nums){
            div += (int)Math.ceil((double)n/mid);
        }

        return div;
    }
    public static int smallestDivisor(int[] nums, int threshold){
        if(nums.length > threshold) return -1;

        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        for(int num : nums){
            high = Math.max(high, num);
        }

        while(low <= high){
            int mid = (low+high)/2;
            if(sumOfDivisor(nums, mid) <= threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {44,22,33,11,1};
        int threshold = 5;
        System.out.println(smallestDivisor(arr, threshold));
    }
}
