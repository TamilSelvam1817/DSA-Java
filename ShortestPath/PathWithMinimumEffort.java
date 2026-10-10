import java.util.PriorityQueue;

class Pair{
    int distance, row, col;
    Pair(int distance, int row, int col){
        this.distance= distance;
        this.row = row;
        this.col = col;
    }
}
public class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights){
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
        int[][] dist = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = (int)1e9;
            }
        }

        dist[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!pq.isEmpty()){
            Pair it = pq.poll();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;

            if(row == n-1 && col == m-1) return diff;

            for(int i=0; i<4; i++){
                int newr = row + drow[i];
                int newc = col + dcol[i];
                if(newr >= 0 && newr < n && newc >= 0 && newc < m){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);
                    if(newEffort < dist[newr][newc]){
                        dist[newr][newc] = newEffort;
                        pq.offer(new Pair(newEffort, newr, newc));
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        //int[][] heights = {{1,2,3},{3,8,4},{5,3,5}};
        int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        System.out.println(minimumEffortPath(heights));
    }
}
