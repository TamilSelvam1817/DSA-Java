public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust){
        int[] score = new int[n+1];

        for(int[] t : trust){
            int a = t[0];
            int b = t[1];
            score[a]--;
            score[b]++;
        }

        for(int i=1; i<=n; i++){
            if(score[i] == n-1)
                return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3},{3,1}};
        System.out.println(findJudge(n, trust));
    }
}
