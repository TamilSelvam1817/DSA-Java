import java.util.Arrays;

public class FloydWarshellAlgorithm {
    public static int[][] floyd(int[][] dist){
        int n = dist.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] == 1e8){
                    dist[i][j] = (int)1e8;
                }
                if(i == j) dist[i][j] = 0;
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k] != 1e8 && dist[k][j] != 1e8){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] == 1e8)
                    dist[i][j] = -1;
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        //int[][] dist = {{0, 4, (int)1e8, 5, (int)1e8}, {(int)1e8, 0, 1, (int)1e8, 6}, {2, (int)1e8, 0, 3, (int)1e8}, {(int)1e8, (int)1e8, 1, 0, 2}, {1, (int)1e8, (int)1e8, 4, 0}};

        int[][] dist = {{0,-1,2},{1,0,(int)1e8},{3,1,0}};

        int[][] res = floyd(dist);

        // for(int i=0; i<res.length; i++){
        //     for(int j=0; j<res[0].length; j++){
        //         System.out.print(res[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        for(int[] ans : res){
            System.out.println(Arrays.toString(ans));
        }
    }
}

/*
int n = dist.length;
        int INF = (int) 1e8;

        // Convert -1 to INF
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j && dist[i][j] == -1) {
                    dist[i][j] = INF;
                }
            }
        }

        // Floyd-Warshall
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != INF &&
                        dist[k][j] != INF) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        // Negative cycle detection
        for (int i = 0; i < n; i++) {

            if (dist[i][i] < 0) {
                System.out.println("Negative cycle exists");
            }
        }

        // Convert INF back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dist[i][j] == INF) {
                    dist[i][j] = -1;
                }
            }
        }

        return dist;
 */