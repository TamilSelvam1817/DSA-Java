import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int distance, row, col;
    Pair(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
public class ShortestPathInBinaryMaze {
    public static int shortestPath(int[][] grid, int[] source, int[] destination){
        int n = grid.length;
        int m = grid[0].length;

        if(source[0] == destination[0] && source[1] == destination[1])
            return 0;

        Queue<Pair> q=  new LinkedList<>();
        int[][] dist = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = (int)1e9;
            }
        }

        dist[source[0]][source[1]] = 0;
        q.offer(new Pair(0, source[0], source[1]));

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair it = q.poll();
            int dis = it.distance;
            int r = it.row;
            int c = it.col;

            for(int i=0; i<4; i++){
                int newr = r + drow[i];
                int newc = c + dcol[i];

                if(newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]){
                    dist[newr][newc] = dis + 1;

                    if(newr == destination[0] && newc == destination[1]) return dis + 1;
                    q.offer(new Pair(dis + 1, newr, newc));
                }
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,0},{1,0,1,0,1}};
        int[] source = {0,0};
        int[] destination = {3,4};

        System.out.println(shortestPath(grid, source, destination));
    }
}
