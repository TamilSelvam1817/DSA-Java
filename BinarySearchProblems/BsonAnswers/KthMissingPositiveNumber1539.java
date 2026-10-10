public class KthMissingPositiveNumber1539 {
    /* public static int findKthPositive(int[] arr, int k){
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= k){
                k++;
            }else{
                break;
            }
        }

        return k;
    } */

    public static int findKthPositive(int[] arr, int k){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = (low+high)/2;

            int missing = arr[mid] - (mid+1);
            if(missing < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return high+1+k;
    }
    public static void main(String[] args) {
        int[] arr = {3,4};
        int k = 2;
        System.out.println(findKthPositive(arr, k));
    }
}
