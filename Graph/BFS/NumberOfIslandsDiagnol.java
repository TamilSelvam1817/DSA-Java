import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class NumberOfIslandsDiagnol {
    private static void bfs(int row, int col, char[][] grid, int[][] vis){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            for(int drow=-1; drow<=1; drow++){
                for(int dcol=-1; dcol<=1; dcol++){
                    int nrow = r + drow;
                    int ncol = c + dcol;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == 'L' && vis[nrow][ncol] == 0
                    ){
                        vis[nrow][ncol] = 1;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    public static int cntIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 'L' && vis[i][j] == 0){
                    cnt++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        // char[][] grid = {{'L', 'L', 'W', 'W', 'W'}, 
        //         {'W', 'L', 'W', 'W', 'L'}, 
        //         {'L', 'W', 'W', 'L', 'L'}, 
        //         {'W', 'W', 'W', 'W', 'W'}, 
        //         {'L', 'W', 'L', 'L', 'W'}};

        char[][] grid = {{'W', 'L', 'L', 'L', 'W', 'W', 'W'}, 
                         {'W', 'W', 'L', 'L', 'W', 'L', 'W'}};

                System.out.println(cntIslands(grid));
    }
}
