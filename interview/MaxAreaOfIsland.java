import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class MaxAreaOfIsland {
    private static int bfs(int row, int col, int[][] grid, int[][] vis, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = 1;

        int size = 0;
        while(!q.isEmpty()){
            Pair it = q.poll();
            int r = it.row;
            int c = it.col;
            size++;

            for(int drow=-1; drow<=1; drow++){
                for(int dcol=-1; dcol<=1; dcol++){
                    int newr = r + drow;
                    int newc = c + dcol;

                    if(newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && vis[newr][newc] == 0){
                        q.offer(new Pair(newr, newc));
                        vis[newr][newc] = 1;
                    }
                }
            }
        }

        return size;
    }
    public static int findMaxArea(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int maxSize = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    int size = bfs(i, j, grid, vis, n, m);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1},{1,1,0,0}};
        System.out.println(findMaxArea(grid));
    }
}
