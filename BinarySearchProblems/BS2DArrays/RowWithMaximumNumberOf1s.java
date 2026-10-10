public class RowWithMaximumNumberOf1s{
    /* public static int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int cntMax = 0;
        int index = -1;
        
        for(int i=0; i<n; i++){
            int cntOnes = 0;
            for(int j=0; j<m; j++){
                cntOnes += arr[i][j];
            }
            if(cntOnes > cntMax){
                cntMax = cntOnes;
                index = i;
            }
        }
        
        return index;
    } */

    private static int lowerBound(int[] arr, int k){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] >= k){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    public static int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int cntMax = 0;
        int index = -1;
        
        for(int i=0; i<n; i++){
            int cntOnes = m - lowerBound(arr[i], 1);
            if(cntOnes > cntMax){
                cntMax = cntOnes;
                index = i;
            }
        }
        
        return index;
    }
    public static void main(String[] args){
        int[][] arr = {{0,1,1,1},{0,0,1,1},{1,1,1,1},{0,0,0,0}};
        System.out.println(rowWithMax1s(arr));
    }
}