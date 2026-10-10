import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    private static String toString(int r, int c){
        return r+" "+c;
    }
    private static void dfs(int row, int col, int[][] grid, int[][] vis, List<String>vec, int row0, int col0){
        vis[row][col] = 1;
        vec.add(toString(row-row0, col-col0));
        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1
            ){
                dfs(nrow, ncol, grid, vis, vec, row0, col0);
            }
        }
    }
    public static int countIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<List<String>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m ; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    List<String> vec = new ArrayList<>();
                    dfs(i, j, grid, vis, vec, i, j);
                    set.add(vec);
                }
            }
        }

        return set.size();
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,0,1},
            {1,1,0,1,1}
        };

        System.out.println(countIslands(grid));
    }
}
