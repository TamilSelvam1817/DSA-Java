public class ImplementLowerBound {
    public static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int lb = arr.length;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] >= target){
                lb = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return lb;
    } 
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 111;
        System.out.println(lowerBound(arr, target));
    }
}
