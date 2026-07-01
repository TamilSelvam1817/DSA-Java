public class CeilInSortedArray {
    public static int findCeil(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int ceil = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] >= x){
                ceil = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return ceil;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int x = 0;
        System.out.println(findCeil(arr, x));
    }
}
