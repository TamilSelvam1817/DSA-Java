public class SearchInSortedmatrix74 {
    // public static boolean searchMatrix(int[][] mat, int x) {
    //     if(mat.length == 0) return true;
        
    //     int n = mat.length;
    //     int m = mat[0].length;
        
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(mat[i][j] == x){
    //                 return true;
    //             }
    //         }
    //     }
        
    //     return false;
    // }

    /* private static boolean binarySearch(int[] arr, int tar){
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] == tar){
                return true;
            }else if(arr[mid] > tar){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return false;
    }
    public static boolean searchMatrix(int[][] mat, int x) {
        if(mat.length == 0) return true;
        
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i=0; i<n; i++){
            if(mat[i][0] <= x && x <= mat[i][m-1]){
                return binarySearch(mat[i], x);
            }
        }
        
        return false;
    } */

    public static boolean searchMatrix(int[][] mat, int x) {
        if(mat.length == 0) return true;
        
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0;
        int high = n*m-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m; 
            
            if(mat[row][col] == x){
                return true;
            }else if(mat[row][col] > x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,5,9,11},{14,20,21,26},{30,34,43,50}};
        int target = 43;
        System.out.println(searchMatrix(mat, target));
    }
}
