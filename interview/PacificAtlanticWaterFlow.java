import java.util.*;

public class PacificAtlanticWaterFlow {
    private static void dfs(int row, int col, boolean[][] visited, int[][] heights, int n, int m){
        visited[row][col] = true;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0; i<4; i++){
            int newr = row + drow[i];
            int newc = col + dcol[i];
            if(newr >= 0 && newr < n && newc >= 0 && newc < m &&
                heights[newr][newc] >= heights[row][col] && visited[newr][newc] == false
            ){
                dfs(newr, newc, visited, heights, n, m);
            }
        }
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights){
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(i, 0, pacific, heights, n, m);
        }
        for(int j=0; j<m; j++){
            dfs(0, j, pacific, heights, n, m);
        }

        boolean[][] atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(i, m-1, atlantic, heights, n, m);
        }
        for(int j=0; j<m; j++){
            dfs(n-1, j, atlantic, heights, n, m);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        List<List<Integer>> res = pacificAtlantic(heights);
        System.out.println(res);
    }
}
