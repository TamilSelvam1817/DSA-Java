public class CityWithSmallestNumberOfNeighborsAtThresholdDistance {

    public static int findTheCity(int n, int[][] edges, int distanceThreshold){
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int i=0; i<n; i++)
            dist[i][i] = 0;

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;

        for(int city=0; city<n; city++){
            int cnt = 0;
            for(int adjCity=0; adjCity<n; adjCity++){
                if(dist[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
    public static void main(String[] args) {
        // int n = 4;
        // int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        // int distanceThreshold = 4;
        int n = 5;
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 2;

        System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}
