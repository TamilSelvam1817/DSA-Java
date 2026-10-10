import java.util.Arrays;

public class FloodFill {
    private static void dfs(int row, int col, int[][] image, int[][] ans, int iniColor, int color, int[] drow, int[] dcol){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;

        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                && image[nrow][ncol] == iniColor && ans[nrow][ncol] != color
            ){
                dfs(nrow, ncol, image, ans, iniColor, color, drow, dcol);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        dfs(sr, sc, image, ans, iniColor, color, drow, dcol);
        return ans;
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = floodFill(image, sr, sc, color);

        for(int[] res : result){
            System.out.println(Arrays.toString(res));
        }
    }
}