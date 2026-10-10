public class AllocateMinimumPages {
    private static boolean isAllocatePossible(int[] arr, int page, int k){
        int student = 1;
        int pagesStudent = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] > page) return false;
            
            if(pagesStudent + arr[i] <= page){
                pagesStudent += arr[i];
            }else{
                student++;
                pagesStudent = arr[i];
            }
        }
        
        if(student > k) return false;
        
        return true;
    }
    /* public static int findPages(int[] arr, int k) {
        
        if(arr.length < k) return -1;
        
        int max = 0;
        int sum = 0;
        for(int a : arr){
            max = Math.max(max, a);
            sum += a;
        }
        
        for(int page=max; page<=sum; page++){
            if(isAllocatePossible(arr, page, k)){
                return page;
            }
        }
        
        return -1;
    } */

    public static int findPages(int[] arr, int k) {
        
        if(arr.length < k) return -1;
        
        int low = 0;
        int high = 0;
        for(int a : arr){
            low = Math.max(low, a);
            high += a;
        }
        int ans = 0;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(isAllocatePossible(arr, mid, k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr, k));
    }
}
