public class NthRootOfM {
    /* public static int func(int mid, int n, int m){
        int ans = 1;
        for(int i=0; i<n; i++){
            ans *= mid;
        }
        
        return ans;
    } 
        
     public static int nthRoot(int n, int m) {
        
        if(m == 0) return 0;
        
        for(int i=1; i<=m; i++){
            if(func(i, n, m) == m){
                return i;
            }else if(func(i, n, m) > m){
                break;
            }
        }
        
        return -1;
    } */

    public static int nthRoot(int n, int m){
        if(m == 0) return 0;

        int low = 1;
        int high = m;

        while(low <= high){
            int mid = (low+high)/2;
            long ans = 1;
            for(int i=0; i<n; i++){
                ans *= mid;

                if(ans > m) break;
            }

            if(ans == m) return mid;

            if(ans < m) low = mid+1;
            else high = mid-1;
        }

        return -1;
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 16;
        System.out.println(nthRoot(n, m));
    }
}
