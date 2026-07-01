public class FindKthRotation {
    public static int findKRotation(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[low] <= nums[high]){
                if(nums[low] < ans){
                    index = low;
                    ans = nums[low];
                }
                break;
            }

            if(nums[low] <= nums[mid]){
                if(nums[low] < ans){
                    index = low;
                    ans = nums[low];
                }
                low = mid+1;
            }else{
                if(nums[mid] < ans){
                    index = mid;
                    ans = nums[mid];
                }
                high = mid-1;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(findKRotation(arr));
    }
}
