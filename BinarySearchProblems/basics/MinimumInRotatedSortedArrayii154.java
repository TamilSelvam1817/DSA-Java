public class MinimumInRotatedSortedArrayii154 {
    public static int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int mini = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[low] <= nums[high]){
                mini = Math.min(mini, nums[low]);
            }

            if(nums[low] <= nums[mid] && nums[mid] <= nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low] <= nums[mid]){
                mini = Math.min(mini, nums[low]);
                low = mid+1;
            }else{
                mini = Math.min(mini, nums[mid]);
                high = mid-1;
            }
        }

        return mini;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1,2};
        System.out.println(findMin(nums));
    }
}
