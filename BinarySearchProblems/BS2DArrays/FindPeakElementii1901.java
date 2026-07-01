import java.util.*;
public class FindPeakElementii1901 {
    /* public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;

        while(low <= high){
            int mid = (low + high)/2;
            int row = maxElement(mat, mid);
            int left = mid-1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid+1 < m ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right)
            return new int[] {row, mid};
            else if(mat[row][mid] < left)
            high = mid-1;
            else
            low = mid+1;
        }
        return new int[] {-1, -1};
    }
    private static int maxElement(int[][] nums, int col){
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i][col] > maxValue){
                maxValue = nums[i][col];
                index = i;
            }
        }
        return index;
    } */

    private static int maxElement(int[][] nums, int col){
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i][col] > maxVal){
                maxVal = nums[i][col];
                index = i;
            }
        }
        
        return index;
    }
    public static ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            int row = maxElement(mat, mid);
            int left = mid-1 >= 0 ? mat[row][mid-1] : Integer.MIN_VALUE;
            int right = mid+1 < m ? mat[row][mid+1] : Integer.MIN_VALUE;
            
            if(mat[row][mid] >= left && mat[row][mid] >= right){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(row);
                ans.add(mid);
                return ans;
            }else if(mat[row][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
    public static void main(String[] args) {
        int[][] mat = {{10,20,15},{21,30,14},{7,16,32}};
        /* int[] res = findPeakGrid(mat);
        System.out.println(Arrays.toString(res)); */

        ArrayList<Integer> res = findPeakGrid(mat);
        System.out.println(res);
    }
}
