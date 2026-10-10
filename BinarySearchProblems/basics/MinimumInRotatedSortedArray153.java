public class MinimumInRotatedSortedArray153 {
    public static int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int mini = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[low] <= nums[high]){
                mini = Math.min(mini, nums[low]);
                break;
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
        int[] arr = {11,13,15,17};
        System.out.println(findMin(arr));
    }
}
