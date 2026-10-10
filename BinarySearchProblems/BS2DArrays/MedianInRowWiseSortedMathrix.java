public class MedianInRowWiseSortedMathrix {
    private static int upperBound(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] > x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    private static int cntsmallEqual(int[][] mat, int x){
        int cnt = 0;
        for(int i=0; i<mat.length; i++){
            cnt += upperBound(mat[i], x);
        }
        
        return cnt;
    }
    public static int median(int[][] mat) {
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i=0; i<n ; i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m-1]);
        }
        
        int req = (n*m)/2;
        
        while(low <= high){
            int mid = (low+high)/2;
            int smallEqual = cntsmallEqual(mat, mid);
            
            if(smallEqual <= req){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return low;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {3},
            {4},
            {10}
        };

        System.out.println(median(matrix));
    }
}
