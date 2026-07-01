public class SplitArrayLargestSum410 {
    private static boolean isPossible(int[] nums, int mid, int k){
        int numOfSubArrays = 1;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > mid) return false;

            if(sum + nums[i] <= mid){
                sum += nums[i];
            }else{
                numOfSubArrays++;
                sum = nums[i];
            }
        }

        if(numOfSubArrays > k) return false;

        return true;
    }
    public static int splitArray(int[] nums, int k){
        if(k > nums.length) return -1;

        int low = 0;
        int high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        int ans = 0;

        while(low <= high){
            int mid = (low+high)/2;

            if(isPossible(nums, mid, k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
}
