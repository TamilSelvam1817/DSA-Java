public class SearchInRotatedSortedArray33 {
    /* public static int search(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    } */

    public static int search(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(arr, target));
    }
}
