public class FindCenterOfStarGraph {
    public static int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        if(a == c || a == d) return a;

        return b;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenter(graph));
    }
}
