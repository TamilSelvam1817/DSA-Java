import java.util.Arrays;

public class FindTheDegreeOfEachVertex {
    public static int[] findDegrees(int[][] matrix){
        int n = matrix.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int degree = 0;
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1)
                    degree++;
            }
            ans[i] = degree;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0,1,0},{1,0,0},{0,0,0}};
        int[] res = findDegrees(matrix);
        System.out.println(Arrays.toString(res));
    }
}
