public class FloorInSortedArray {
    public static int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int floor = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] <= x){
                floor = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return floor;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 0;
        System.out.println(findFloor(arr, x));
    }
}
