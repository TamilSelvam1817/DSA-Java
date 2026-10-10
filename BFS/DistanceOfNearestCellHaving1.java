import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int row;
    int col;
    int step;
    Pair(int row, int col, int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
public class DistanceOfNearestCellHaving1 {
    public static List<List<Integer>> nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = 1;
                    q.offer(new Pair(i, j, 0));
                }else{
                    vis[i][j] = 0;
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().step;
            q.remove();

            dist[row][col] = step;
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                    vis[nrow][ncol] == 0
                ){
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol, step+1));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<m; j++){
                row.add(dist[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{1,1,0},{1,0,0}};
        List<List<Integer>> res = nearest(grid);
        System.out.println(res);
    }
}
