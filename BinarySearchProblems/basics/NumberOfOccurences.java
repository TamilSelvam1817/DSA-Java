public class NumberOfOccurences {
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

    public static int countFreq(int[] nums, int target){
        int[] ans = searchRange(nums, target);
        
        if(ans[0] == -1) return 0;

        return ans[1]-ans[0]+1;
    }
    public static void main(String[] args) {
        int[] arr = {8, 9, 10, 12, 12, 12};
        int target = 12;
        System.out.println(countFreq(arr, target));
    }
}
