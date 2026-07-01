public class ImplementUpperBound {
    public static int upperBound(int[] arr, int target) {
        
        int low = 0;
        int high = arr.length-1;
        int ub = arr.length;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] > target){
                ub = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return ub;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 100;
        System.out.println(upperBound(arr, target));
    }
}
