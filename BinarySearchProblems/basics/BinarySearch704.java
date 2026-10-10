public class BinarySearch704 {
    public static int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    } 

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(binarySearch(nums, target));
    }
}



/* public static int binarySearch(int[] nums, int target){
        return  search(nums, 0, nums.length-1, target);
    }
    private static int search(int[] nums, int low, int high, int target){
        if(low > high) return -1;

        int mid = (low+high)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return search(nums, low, mid-1, target);

        return search(nums, mid+1, high, target);
    } */