import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int distance, row, col;
    Pair(int distance, int row, int col){
        this.distance= distance;
        this.row = row;
        this.col = col;
    }
}
public class ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        if(n == 1) return 1;

        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = (int)1e9;
            }
        }

        dist[0][0] = 1;
        q.offer(new Pair(1, 0, 0));

        while(!q.isEmpty()){
            Pair it = q.poll();
            int dis = it.distance;
            int r = it.row;
            int c = it.col;

            for(int drow=-1; drow<=1; drow++){
                for(int dcol=-1; dcol<=1; dcol++){
                    int newr = r + drow;
                    int newc = c + dcol;

                    if(newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]){
                        dist[newr][newc] = dis + 1;

                        if(newr == n-1 && newc == n-1) return dis + 1;
                        q.offer(new Pair(dis + 1, newr, newc));
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
