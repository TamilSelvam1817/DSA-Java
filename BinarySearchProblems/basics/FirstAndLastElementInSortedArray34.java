import java.util.Arrays;

public class FirstAndLastElementInSortedArray34 {
    // public static int[] searchRange(int[] nums, int target){
    //     int first = -1;
    //     int last = -1;

    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i] == target){
    //             if(first == -1) first = i;
    //             last = i;
    //         }
    //     }

    //     return new int[]{first, last};
    // }
    private static int firstOccurence(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int first = -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return first;
    }

    private static int lastOccurence(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int last = -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                last = mid;
                low = mid+1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return last;
    }
    public static int[] searchRange(int[] nums, int target){
        int fisrt = firstOccurence(nums, target);
        if(fisrt == -1)
            return new int[]{-1, -1};

        int last = lastOccurence(nums, target);
        return new int[]{fisrt, last};
    }
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(arr, target);
        System.out.println(Arrays.toString(res));
    }
}
